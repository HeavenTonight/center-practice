package cn.yong.center.practice.infrastructure.repo.impl;

import cn.yong.center.practice.constants.enums.UserMessageStatusEnum;
import cn.yong.center.practice.domain.service.UserMessageService;
import cn.yong.center.practice.infrastructure.dao.UserMessageDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ogy
 * @date 2020/6/11 14:11
 */
@Service
@Slf4j
public class UserMessageServiceImpl implements UserMessageService {
    @Resource
    private UserMessageDAO userMessageDAO;
    @Override
    public Long getUserMessageCount(Long userId, UserMessageStatusEnum status) {
        return userMessageDAO.getUserMessageCount(userId,status);
    }
}
