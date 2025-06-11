package com.wfg.utils;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

// 使用 @Data 注解生成 getter、setter、toString 等方法
public class Result<T> implements Serializable {
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    private static final long serialVersionUID = 1455453388919737646L;
    private Integer code; // 响应状态
    private String message;  // 返回信息
    private T data; // 数据

    // 无参构造器
    public Result() {
    }

    // 全参构造器
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功响应，无数据
    @NotNull
    public static <T> Result<T> success() {
        return new Result<>(200, "success", null);
    }

    // 成功响应，有数据
    @NotNull
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}