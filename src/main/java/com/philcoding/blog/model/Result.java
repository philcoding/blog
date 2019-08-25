package com.philcoding.blog.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.philcoding.blog.enums.ResultCodeEnum;

import java.util.Date;

public class Result<T> {

    /**
     * 业务状态响应码
     */
    private int code;

    /**
     * 响应结果 成功/失败
     */
    private boolean success;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应时间
     */
    private Date timestamp;

    /**
     * 响应数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
        this.timestamp = new Date();
    }

    public static Result success() {
        return new Result()
                .setCode(ResultCodeEnum.SUCCESS.code())
                .setSuccess(true)
                .setMessage(ResultCodeEnum.SUCCESS.message());
    }

    public static <T> Result success(T data) {
        return new Result<T>()
                .setCode(ResultCodeEnum.SUCCESS.code())
                .setSuccess(true)
                .setMessage(ResultCodeEnum.SUCCESS.message())
                .setData(data);
    }

    public static Result fail(String message) {
        return new Result()
                .setCode(ResultCodeEnum.FAIL.code())
                .setSuccess(false)
                .setMessage(message);
    }

    public static Result fail(int code, String message) {
        return new Result()
                .setCode(code)
                .setSuccess(false)
                .setMessage(message);
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Result setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
}
