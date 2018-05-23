package com.jyfw.jyfwser.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class DemandVO {

    private Integer id;
    private Integer uid;
    private String username;
    private Date dealTime;
    private String dealTimeFormat;
    private String dealObject;
    private Integer dealNum;
    private Integer dealPrice;
    private Integer status;
    private String category;

}
