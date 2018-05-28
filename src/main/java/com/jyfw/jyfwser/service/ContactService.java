package com.jyfw.jyfwser.service;

import com.jyfw.jyfwser.pojo.entity.ContactEntity;

import java.util.List;

/**
 * @author: chunxiao
 * @description: 合约接口
 * @date: created in 19:15 2018/5/26
 */
public interface ContactService {

    void insertContact(ContactEntity contact);

    List<ContactEntity> listContactByUid(Integer uid);

    List<ContactEntity> listContactLimitSix();

    List<ContactEntity> listCompleteContact(Integer page, Integer count);

    ContactEntity getContactByCid(Integer cid);

}
