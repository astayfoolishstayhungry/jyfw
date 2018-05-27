package com.jyfw.jyfwser.pojo.entity;

import lombok.Data;

/**
 * @author: chunxiao
 * @description: 管理员entity
 * @date: created in 23:34 2018/2/28
 */
@Data
public class AdminEntity {

    private Integer adminId;
    private String adminName;
    private String password;
    private String realName;
    private String phone;
    private Integer status;

}
