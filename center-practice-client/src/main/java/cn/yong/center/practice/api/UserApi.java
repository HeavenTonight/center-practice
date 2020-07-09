package cn.yong.center.practice.api;

import cn.yong.center.practice.model.command.UserCommand;
import cn.yong.center.practice.model.dto.UserDTO;
import cn.yong.common.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
 * @author ogy
 */
@Api(value = "用户管理", tags = "用户管理")
@RequestMapping("/center/practice/user")
public interface UserApi {
    /**
    * 添加用户
     * @param userCommand 参数
    *@return  是否
    */
    @PostMapping
    @ApiOperation(value = "新增用户")
    JsonResult<Boolean> addUser(@RequestBody UserCommand userCommand);
}
