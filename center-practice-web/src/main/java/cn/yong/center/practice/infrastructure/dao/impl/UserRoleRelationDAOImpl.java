package cn.yong.center.practice.infrastructure.dao.impl;

import cn.yong.center.practice.domain.model.UserRoleRelation;
import cn.yong.center.practice.infrastructure.dao.UserRoleRelationDAO;
import cn.yong.center.practice.infrastructure.mapper.UserRoleRelationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;


/**
 * 配送单信息DAO组件实现
 *
 * @author ogy
 */
@Repository
public class UserRoleRelationDAOImpl extends ServiceImpl<UserRoleRelationMapper, UserRoleRelation> implements UserRoleRelationDAO {

}