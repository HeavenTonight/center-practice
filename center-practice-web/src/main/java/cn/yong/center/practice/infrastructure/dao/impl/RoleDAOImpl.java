package cn.yong.center.practice.infrastructure.dao.impl;

import cn.yong.center.practice.domain.model.Role;
import cn.yong.center.practice.infrastructure.dao.RoleDAO;
import cn.yong.center.practice.infrastructure.mapper.RoleMapper;
import cn.yong.center.practice.model.dto.RoleDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


/**
 * 配送单信息DAO组件实现
 *
 * @author ogy
 */
@Repository
public class RoleDAOImpl extends ServiceImpl<RoleMapper, Role> implements RoleDAO {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<RoleDTO> getListByUserId(Long userId) {
        return roleMapper.getListByUserId(userId);
    }
}