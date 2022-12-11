package com.aliaszen.code.gen.exception;

/**
 * 业务异常
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-10
 */
public class ServiceException extends RuntimeException {
    private String code;

    private Object[] args;

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public ServiceException(String code, Object... args) {
        super();
        this.code = code;
        this.args = args;
    }
}
