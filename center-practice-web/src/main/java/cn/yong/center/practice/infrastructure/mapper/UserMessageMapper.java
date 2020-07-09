package cn.yong.center.practice.infrastructure.mapper;

import cn.yong.center.practice.constants.enums.UserMessageStatusEnum;
import cn.yong.center.practice.domain.model.UserMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ogy
 */
@Mapper
public interface UserMessageMapper extends BaseMapper<UserMessage> {

    /** 获取用户消息数量
     * @param userId 用户id
     * @param status 消息状态
     *@return 消息数量
     */
    Long getUserMessageCount(@Param("userId") Long userId,@Param("status") UserMessageStatusEnum status);
}