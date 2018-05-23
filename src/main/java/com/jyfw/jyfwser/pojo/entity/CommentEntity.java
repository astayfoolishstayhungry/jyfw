package com.jyfw.jyfwser.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CommentEntity {

    private Integer id;
    private Integer commentType;
    private Integer ObjectId;
    private String content;
    private Integer uid;
    private Integer status;
    private Date createTime;

}
