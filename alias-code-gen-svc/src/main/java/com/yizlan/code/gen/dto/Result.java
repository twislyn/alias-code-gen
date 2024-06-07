package com.yizlan.code.gen.dto;

import java.io.Serializable;

/**
 * 返回结果
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-28
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    // 返回是否成功
    private Boolean success = false;

    // 返回信息
    private String msg = "操作成功";

    /**
     * 错误码
     */
    private String code;

    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Result() {
    }

    private Result(Boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构建返回结果
     *
     * @param success
     * @param msg
     * @param code
     * @param data
     * @return
     */
    private static <T> Result<T> build(Boolean success, String code, String msg, T data) {
        return new Result<>(success, code, msg, data);
    }

    /**
     * 构建返回结果
     *
     * @param success
     * @param msg
     * @param data
     * @return
     */
    private static <T> Result<T> build(Boolean success, String msg, T data) {
        return build(success, msg, null, data);
    }

    /**
     * 构建成功结果
     *
     * @param msg
     * @param data
     * @return
     */
    public static <T> Result<T> success(String msg, T data) {
        return build(Boolean.TRUE, msg, data);
    }

    /**
     * 构建失败结果
     * @param code
     * @param msg
     * @return
     */
    public static <T> Result<T> failure(String code, String msg) {
        return build(Boolean.FALSE, code, msg, null);
    }

    /**
     * 构建失败结果
     *
     * @param msg
     * @return
     */
    public static <T> Result<T>  failure(String msg) {
        return build(Boolean.FALSE, msg,null);
    }

    /**
     * 构建成功结果
     *
     * @return
     */
    public static <T> Result<T> success() {
        return success(null, null);
    }
}
