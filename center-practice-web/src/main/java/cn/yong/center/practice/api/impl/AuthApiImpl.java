package cn.yong.center.practice.api.impl;

import cn.yong.center.practice.api.AuthApi;
import cn.yong.center.practice.domain.service.AuthService;
import cn.yong.center.practice.model.dto.UserDTO;
import cn.yong.common.result.JsonResult;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ogy
 */
@RestController
public class AuthApiImpl implements AuthApi {
    @Resource
    private AuthService authService;
    @Override
    public JsonResult<UserDTO> backendLogin(String userNo, String password) {
        return JsonResult.create(authService.backendLogin(userNo,password));
    }
}
