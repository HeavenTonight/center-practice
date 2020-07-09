package cn.yong.center.practice.domain.service;


import cn.yong.center.practice.constants.enums.UserMessageStatusEnum;

/**
 * @author ogy
 * @date 2020/6/11 14:11
 */
public interface UserMessageService {

    /** 获取用户消息数量
     * @param userId 用户id
     * @param status 消息状态
     *@return 消息数量
     */
    Long getUserMessageCount(Long userId,UserMessageStatusEnum status);
}
