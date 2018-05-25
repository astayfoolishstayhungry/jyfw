package com.jyfw.jyfwser.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TopicEntity {
    private Integer id;
    private Integer uid;
    private String content;
    private Date createTime;
    private Integer status;
    private String category;
    private String topicName;
    //发布话题的用户名-需要关联user表查询
    private String name;
}
