package com.jyfw.jyfwser.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: chunxiao
 * @description:
 * @date: created in 0:12 2018/5/25
 */
@Data
public class ConfirmDemandEntity {

    private String name;
    private String category;
    private String dealObject;
    private Integer dealNum;
    private Integer dealPrice;
    private Date dealTime;

}
