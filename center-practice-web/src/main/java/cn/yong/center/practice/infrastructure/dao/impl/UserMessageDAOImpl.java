package cn.yong.center.practice.infrastructure.dao.impl;

import cn.yong.center.practice.constants.enums.UserMessageStatusEnum;
import cn.yong.center.practice.domain.model.UserMessage;
import cn.yong.center.practice.infrastructure.dao.UserMessageDAO;
import cn.yong.center.practice.infrastructure.mapper.UserMessageMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


/**
 * 配送单信息DAO组件实现
 *
 * @author ogy
 */
@Repository
public class UserMessageDAOImpl extends ServiceImpl<UserMessageMapper, UserMessage> implements UserMessageDAO {

    @Resource
    private UserMessageMapper userMessageMapper;
    @Override
    public Long getUserMessageCount(Long userId, UserMessageStatusEnum status) {
        return userMessageMapper.getUserMessageCount(userId,status);
    }
}