package cn.yong.center.practice.infrastructure.repo.impl;


import cn.yong.center.practice.domain.model.User;
import cn.yong.center.practice.domain.model.UserRoleRelation;
import cn.yong.center.practice.domain.service.UserService;
import cn.yong.center.practice.infrastructure.dao.UserDAO;
import cn.yong.center.practice.infrastructure.dao.UserRoleRelationDAO;
import cn.yong.center.practice.model.command.UserCommand;
import cn.yong.center.practice.utils.NumberUtils;
import cn.yong.common.util.CloneUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ogy
 * @date 2020/6/11 14:11
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;
    @Resource
    private UserRoleRelationDAO userRoleRelationDAO;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    @Transactional(rollbackFor = {RuntimeException.class,Exception.class})
    public Boolean addUser(UserCommand userCommand) {
        //增加user表数据
        User user = CloneUtil.clone(userCommand, User.class);
        user.setUserNo(NumberUtils.generateUserNo(redisTemplate));
        boolean save = userDAO.save(user);
        //增加user-role-relation表数据
        UserRoleRelation userRoleRelation = new UserRoleRelation();
        //默认都是普通用户
        userRoleRelation.setRoleId(1L);
        userRoleRelation.setUserId(user.getId());
        userRoleRelationDAO.save(userRoleRelation);
        return save;
    }
}
