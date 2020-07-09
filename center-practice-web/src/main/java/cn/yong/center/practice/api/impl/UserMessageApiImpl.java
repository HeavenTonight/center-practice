package cn.yong.center.practice.api.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.yong.center.practice.api.UserMessageApi;
import cn.yong.center.practice.constants.enums.ResultErrorEnum;
import cn.yong.center.practice.constants.enums.UserMessageStatusEnum;
import cn.yong.center.practice.domain.service.UserMessageService;
import cn.yong.common.exception.BizException;
import cn.yong.common.result.JsonResult;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author ogy
 */
@RestController
public class UserMessageApiImpl implements UserMessageApi {
    @Resource
    private UserMessageService userMessageService;
    @Override
    public JsonResult<Long> getUserMessageCount(Long userId, UserMessageStatusEnum status) {
        if (BeanUtil.isEmpty(userId)){
            throw new BizException(ResultErrorEnum.PARAM_ERROR);
        }
        return JsonResult.create(userMessageService.getUserMessageCount(userId,status));
    }
}
