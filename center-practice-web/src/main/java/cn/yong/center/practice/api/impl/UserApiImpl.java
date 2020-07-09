package cn.yong.center.practice.api.impl;

import cn.yong.center.practice.api.UserApi;
import cn.yong.center.practice.domain.service.UserService;
import cn.yong.center.practice.model.command.UserCommand;
import cn.yong.center.practice.model.dto.UserDTO;
import cn.yong.common.result.JsonResult;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ogy
 */
@RestController
public class UserApiImpl implements UserApi {

    @Resource
    private UserService userService;

    @Override
    public JsonResult<Boolean> addUser(UserCommand userCommand) {
        return JsonResult.create(userService.addUser(userCommand));
    }
}
