package cn.yong.center.practice.infrastructure.repo.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import cn.yong.center.practice.constants.constant.AuthorizationConstants;
import cn.yong.center.practice.constants.enums.ResultErrorEnum;
import cn.yong.center.practice.domain.model.Menu;
import cn.yong.center.practice.domain.model.User;
import cn.yong.center.practice.domain.service.AuthService;
import cn.yong.center.practice.infrastructure.dao.MenuDAO;
import cn.yong.center.practice.infrastructure.dao.RoleDAO;
import cn.yong.center.practice.infrastructure.dao.UserDAO;
import cn.yong.center.practice.model.dto.MenuDTO;
import cn.yong.center.practice.model.dto.RoleDTO;
import cn.yong.center.practice.model.dto.UserDTO;
import cn.yong.common.exception.BizException;
import cn.yong.common.util.CloneUtil;
import cn.yong.common.util.JWTUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author ogy
 * @date 2020/6/11 14:11
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Value("${jwt.hs256.secretKey}")
    private String secretKey;
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Resource
    private UserDAO userDAO;
    @Resource
    private RoleDAO roleDAO;
    @Resource
    private MenuDAO menuDAO;


    @Override
    public UserDTO backendLogin(String userNo, String password) {
        User user = userDAO.getOne(new LambdaQueryWrapper<User>().eq(User::getUserNo, userNo).eq(User::getPassword, password));
        if (BeanUtil.isEmpty(user)){
            throw new BizException(ResultErrorEnum.USER_PASSWORD_ERROR);
        }
        UserDTO userDTO = CloneUtil.clone(user, UserDTO.class);
        List<RoleDTO> listByUserId = roleDAO.getListByUserId(userDTO.getId());
        userDTO.setRoles(listByUserId);
        Set<Long> collect = listByUserId.stream().map(RoleDTO::getId).collect(Collectors.toSet());
        List<Menu> listByRoleIds = menuDAO.getListByRoleIds(collect);
        String redisKey=AuthorizationConstants.LOGIN_PRIFIX_END+userDTO.getUserNo();
        if (!redisTemplate.hasKey(redisKey)){
            String uuid = IdUtil.simpleUUID();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(AuthorizationConstants.USER_NO,userDTO.getUserNo());
            String token = JWTUtils.createJWT(AuthorizationConstants.ISSUER_CENTER_PRACTICE, uuid, jsonObject.toJSONString(), secretKey, AuthorizationConstants.EXPIRATIONDATE);
            userDTO.setJwt(token);
            redisTemplate.opsForValue().set(redisKey,JSON.toJSONString(userDTO),AuthorizationConstants.EXPIRATIONDATE, TimeUnit.SECONDS);
        }else {
            //设置过期时间
            redisTemplate.expire(redisKey,AuthorizationConstants.EXPIRATIONDATE, TimeUnit.SECONDS);
            String userStr = redisTemplate.opsForValue().get(redisKey);
            UserDTO redisUserDTO = JSONUtil.toBean(userStr, UserDTO.class);
            userDTO.setJwt(redisUserDTO.getJwt());
        }
        if (CollUtil.isNotEmpty(listByRoleIds)){
            userDTO.setMenus(createMenuTree(listByRoleIds));
        }
        return userDTO;
    }

    private List<MenuDTO> createMenuTree(List<Menu> menus){
        List<MenuDTO> allMenuDTOS = CloneUtil.cloneList(menus, MenuDTO.class);
        List<MenuDTO> menuDTOS = allMenuDTOS.stream().filter(it->it.getParentId().equals(0L)).collect(Collectors.toList());
        menuDTOS.forEach(menu->{
            createNextMenuTree(menu,allMenuDTOS);
        });
        return menuDTOS;
    }
    private void createNextMenuTree(MenuDTO menuDTO,List<MenuDTO> menuDTOS){
        menuDTOS.forEach(menu->{
            MenuDTO clone = CloneUtil.clone(menu, MenuDTO.class);
            if (menuDTO.getId().equals(clone.getParentId())){
                if (CollUtil.isEmpty(menuDTO.getMenuDTOS())){
                    menuDTO.setMenuDTOS(new ArrayList<>());
                }
                menuDTO.getMenuDTOS().add(clone);
                createNextMenuTree(clone,menuDTOS);
            }
        });

    }
}
