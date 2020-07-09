package cn.yong.center.practice.infrastructure.dao;


import cn.yong.center.practice.constants.enums.UserMessageStatusEnum;
import cn.yong.center.practice.domain.model.UserMessage;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 用户 DAO
 *
 * @author ogy
 */
public interface UserMessageDAO extends IService<UserMessage> {

    /** 获取用户消息数量
     * @param userId 用户id
     * @param status 消息状态
     *@return 消息数量
     */
    Long getUserMessageCount(Long userId,UserMessageStatusEnum status);
}
