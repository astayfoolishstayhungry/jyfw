package com.jyfw.jyfwser.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description: 需求实体
 * @date: created in 16:39 2018/4/28
 */
@Data
public class DemandEntity {

    private Integer id;
    private Integer uid;
    private Date dealTime;
    private String dealObject;
    private Integer dealNum;
    private Integer dealPrice;
    private Integer status;
    private String desc;
    private Date createTime;

}
