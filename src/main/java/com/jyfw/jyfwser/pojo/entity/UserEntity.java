package com.jyfw.jyfwser.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: lulu
 * @description: 用户实体
 * @date: created in 0:35 2018/2/27
 */
@Data
public class UserEntity {
    private Integer uid;
    private Integer accountType;
    private Integer status;
    private Date createTime;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String avatar;
    private String location;
    private String personIdFrontPage;
    private String personIdBackPage;
    private String des;
}
