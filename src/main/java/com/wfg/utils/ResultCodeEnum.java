package com.wfg.utils;



public enum ResultCodeEnum {
    SUCCESS(200,"操作成功！"),
    ERROR(500,"操作失败");
    /* 状态码 */



    private final Integer code; // 状态码
    private final String message; //  状态信息

    ResultCodeEnum(Integer code,String message){
        this.message=message;
        this.code=code;
    }
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
