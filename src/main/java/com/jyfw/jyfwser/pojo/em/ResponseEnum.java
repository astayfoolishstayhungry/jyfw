package com.jyfw.jyfwser.pojo.em;

/**
 * @description: 响应格式
 */
public enum ResponseEnum {

    SUCCESS(200, "成功"),
    INVALID_PARAM(400, "请求格式错误"),
    AUTH_FAILED(401, "未授权"),
    NEED_AUTH(403, "权限不足"),
    NOT_ALLOW(405, "该方法不被允许"),
    UNSUPPORT(415, "请求类型错误"),
    UNKNOW_ERROR(500, "系统内部错误");

    private Integer code;
    private String desc;


    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
