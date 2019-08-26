package com.philcoding.blog.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.philcoding.blog.enums.ResultCodeEnum;
import com.philcoding.blog.util.IdUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
     * 链路跟踪标识
     */
    private String traceId;

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
        this.traceId = String.valueOf(IdUtil.nextId());
    }

    public static <T> Result success(T data) {

        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS.code());
        result.setSuccess(true);
        result.setMessage(ResultCodeEnum.SUCCESS.message());
        result.setData(data);

        return result;
    }

    public static Result fail(String message) {

        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL.code());
        result.setMessage(message);

        return result;
    }

    public static Result fail(int code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);

        return result;
    }

    public static Map<String, Object> fail(Map<String, Object> model) {

        Result result = new Result();

        Map<String, Object> body = new HashMap<>();
        body.put("code", model.get("status"));
        body.put("message", model.get("message"));
        body.put("success", false);
        body.put("timestamp", result.getTimestamp());
        body.put("traceId", result.getTraceId());

        return body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTraceId() {
        return traceId;
    }

    public Date getTimestamp() {
        return timestamp;
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
