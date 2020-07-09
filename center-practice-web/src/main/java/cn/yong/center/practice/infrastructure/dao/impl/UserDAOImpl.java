package cn.yong.center.practice.infrastructure.dao.impl;

import cn.yong.center.practice.domain.model.User;
import cn.yong.center.practice.infrastructure.dao.UserDAO;
import cn.yong.center.practice.infrastructure.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;


/**
 * 配送单信息DAO组件实现
 *
 * @author ogy
 */
@Repository
public class UserDAOImpl extends ServiceImpl<UserMapper, User> implements UserDAO {

}