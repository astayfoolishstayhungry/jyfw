package com.jyfw.jyfwser.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: chunxiao
 * @description:
 * @date: created in 19:06 2018/5/26
 */
@Data
public class ContactEntity {

    private Integer     id;
    private Integer     sellerUid;
    private String      sellername;
    private String      sellerphone;
    private Integer     buyerUid;
    private String      buyername;
    private String      buyerphone;
    private String      dealTime;
    private String      dealObject;
    private Integer     dealNum;
    private Integer     dealprice;
    private Integer     status;
    private String      desc;
    private Date        createTime;

}
