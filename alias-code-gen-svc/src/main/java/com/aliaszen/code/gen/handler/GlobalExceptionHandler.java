package com.aliaszen.code.gen.handler;

import com.aliaszen.code.gen.dto.Result;
import com.aliaszen.code.gen.exception.ServiceException;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
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
    public Result handleServiceException(ServiceException e) {
        Object[] args = e.getArgs();
        String defaultMessage = ArrayUtils.isEmpty(args) ? e.getCode() : String.valueOf(args[0]);
        String message = messageSource.getMessage(e.getCode(), e.getArgs(), defaultMessage, LocaleContextHolder.getLocale());

        log.error("occurred service exception：" + message, e);

        return wrap(e.getCode(), message);
    }

    private Result wrap(String code, String message) {
        return Result.failure(code, message);
    }
}
