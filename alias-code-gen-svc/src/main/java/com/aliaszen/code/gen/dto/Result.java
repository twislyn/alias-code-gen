package com.aliaszen.code.gen.dto;

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
     * 返回消息类型,用于复杂返回信息,0代表普通返回信息,1*代表特殊返回信息
     */
    private Integer code = 0;

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    private Result(Boolean success, String msg, Integer code, T data) {
        this.success = success;
        this.msg = msg;
        this.code = code;
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
    private static <T> Result<T> build(Boolean success, String msg, Integer code, T data) {
        return new Result<>(success, msg, code, data);
    }

    /**
     * 构建返回结果，code默认值为0
     *
     * @param success
     * @param msg
     * @param data
     * @return
     */
    private static <T> Result<T> build(Boolean success, String msg, T data) {
        return build(success, msg, 0, data);
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
    public static <T> Result<T> failure(Integer code, String msg) {
        return build(Boolean.FALSE, msg, code, null);
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
