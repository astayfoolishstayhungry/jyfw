package com.jyfw.jyfwser.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jyfw.jyfwser.pojo.em.ResponseEnum;

import java.io.Serializable;

/**
 * @description: http响应公共数据
 */
//保证序列化的时候，如果是Null对象，key也会消失
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = 2680448029302221505L;

    private Integer code;
    private String msg;
    private T data;

    private JsonResult() {

    }

    private JsonResult(Integer code) {
        this.code = code;
    }

    private JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private JsonResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    private JsonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return this.code.equals(ResponseEnum.SUCCESS.getCode());
    }

    public static <T> JsonResult<T> createBySuccess() {
        return new JsonResult<T>(ResponseEnum.SUCCESS.getCode());
    }

    public static <T> JsonResult<T> createBySuccessMessage(String msg) {
        return new JsonResult<T>(ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static <T> JsonResult<T> createBySuccess(T data) {
        return new JsonResult<T>(ResponseEnum.SUCCESS.getCode(), data);
    }

    public static <T> JsonResult<T> createBySuccess(String msg, T data) {
        return new JsonResult<T>(ResponseEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> JsonResult<T> createByError() {
        return new JsonResult<T>(ResponseEnum.UNKNOW_ERROR.getCode(), ResponseEnum.UNKNOW_ERROR.getDesc());
    }

    public static <T> JsonResult<T> createByErrorMessage(String errorMessage) {
        return new JsonResult<T>(ResponseEnum.UNKNOW_ERROR.getCode(), errorMessage);
    }

    public static <T> JsonResult<T> createByErrorCodeMessage(Integer code, String errorMessage) {
        return new JsonResult<T>(code, errorMessage);
    }

}
