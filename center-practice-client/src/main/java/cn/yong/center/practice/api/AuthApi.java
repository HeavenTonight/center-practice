package cn.yong.center.practice.api;

import cn.yong.center.practice.model.dto.UserDTO;
import cn.yong.common.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author ogy
 */
@Api(value = "登录管理", tags = "登录管理")
@RequestMapping("/center/practice/auth")
public interface AuthApi {
    /**后台管理系统登录
     * @param userNo 用户账号
     * @param password 密码
    *@return  信息
    */
    @GetMapping("/backend-login")
    @ApiOperation(value = "后台登录")
    JsonResult<UserDTO> backendLogin(@RequestParam("userNo")String userNo,@RequestParam("password")String password);
}
