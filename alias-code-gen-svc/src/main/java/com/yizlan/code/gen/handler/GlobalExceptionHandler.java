package com.yizlan.code.gen.handler;

import com.yizlan.code.gen.dto.Result;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.yizlan.gelato.core.panic.I18nException;
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

    @ExceptionHandler(I18nException.class)
    public Result handleServiceException(I18nException e) {
        String code = (String) e.getCode();
        Object[] args = e.getArgs();
        String defaultMessage = ArrayUtils.isEmpty(args) ? code : String.valueOf(args[0]);
        String message = messageSource.getMessage(code, e.getArgs(), defaultMessage, LocaleContextHolder.getLocale());

        log.error("occurred i18n exception：{}, e: {}" , message, e.getMessage());

        return wrap(code, message);
    }

    private Result wrap(String code, String message) {
        return Result.failure(code, message);
    }
}
