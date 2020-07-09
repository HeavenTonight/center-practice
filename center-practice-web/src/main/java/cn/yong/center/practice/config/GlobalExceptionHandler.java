package cn.yong.center.practice.config;

import cn.yong.common.exception.BizException;
import cn.yong.common.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ogy
 * @date 2020/04/29
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String DEFAULT_MESSAGE = "系统内部错误internal error";

    @ExceptionHandler(Exception.class)
    @ResponseBody
    protected JsonResult<Object> onException(HttpServletRequest request, Exception ex) {
        LOGGER.error(DEFAULT_MESSAGE, ex);
        recordRequestMsg(request);
        if (ex instanceof BizException) {
            BizException bizException = (BizException) ex;
            return JsonResult.create(bizException.getCode(), bizException.getMessage());
        }
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) ex;
            return JsonResult.create(500, validException.getBindingResult().getFieldError() == null ?
                    DEFAULT_MESSAGE : validException.getBindingResult().getFieldError().getDefaultMessage());
        }

        return JsonResult.create(500, DEFAULT_MESSAGE, ex.getStackTrace());
    }

    private void recordRequestMsg(HttpServletRequest request) {
        LOGGER.error("URL:        {}", request.getRequestURL());
        LOGGER.error("HTTP Method:{}", request.getMethod());
        LOGGER.error("IP:         {}", request.getRemoteAddr());
    }
}
