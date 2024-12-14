package com.yizlan.code.gen.handler;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.yizlan.code.gen.common.exception.ServiceException;
import com.yizlan.code.gen.common.protocol.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

/**
 * 全局异常
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-08
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Resource
    private MessageSource messageSource;

    @ExceptionHandler(ServiceException.class)
    public Result<Object> handleServiceException(ServiceException e) {
        String code = e.getCode();
        Object[] args = e.getArgs();
        String defaultMessage = ArrayUtils.isEmpty(args) ? code : String.valueOf(args[0]);
        String message = messageSource.getMessage(code, e.getArgs(), defaultMessage, LocaleContextHolder.getLocale());

        log.error("occurred i18n exception：{}, e: {}", message, e.getMessage());

        return wrap(code, message);
    }

    private Result<Object> wrap(String code, String message) {
        return Result.failure(code, message);
    }
}
