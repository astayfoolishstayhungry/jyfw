package com.jyfw.jyfwser.pojo.vo;

import lombok.Data;

/**
 * @description: 调用聚合数据api返回数据
 * @date: created in 11:49 2018/5/6
 */
@Data
public class JuHeData<T> {

    private String errorCode;
    private JuHeResult result;
    private String reason;

}
