package cn.yong.center.practice.api;

import cn.yong.center.practice.constants.enums.UserMessageStatusEnum;
import cn.yong.common.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author ogy
 */
@Api(value = "用户消息管理", tags = "用户消息管理")
@RequestMapping("/center/practice/user/message")
public interface UserMessageApi {
    /** 获取用户消息数量
     * @param userId 用户id
     * @param status 消息状态
    *@return 消息数量
    */
    @GetMapping("/count")
    @ApiOperation(value = "获取用户消息数量")
    JsonResult<Long> getUserMessageCount(@Param("userId") Long userId,@Param("status") UserMessageStatusEnum status);
}
