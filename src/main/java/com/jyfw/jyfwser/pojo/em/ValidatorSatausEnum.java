package com.jyfw.jyfwser.pojo.em;

/**
 * @description: 验证状态枚举类型
 * @date: created in 14:32 2018/2/27
 */
public enum ValidatorSatausEnum {

    UNVALIDATOR(0, "未认证"), VALIDATOR(1, "认证成功"),
    VALIDATORING(2, "正在验证"), VALIDATOR_FAILED(3, "验证失败，请重新验证")
    ;
    private Integer code;
    private String message;

    private ValidatorSatausEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

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

}
