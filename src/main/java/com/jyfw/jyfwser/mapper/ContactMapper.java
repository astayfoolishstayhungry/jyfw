package com.jyfw.jyfwser.mapper;

import com.jyfw.jyfwser.pojo.entity.ContactEntity;

import java.util.List;

/**
 * @author: chunxiao
 * @description: 合约详情
 * @date: created in 19:04 2018/5/26
 */
public interface ContactMapper {

    void insertContract(ContactEntity contact);

    List<ContactEntity> listContactByUid(Integer uid);

    List<ContactEntity> listContactLimitSix();

    List<ContactEntity> listCompleteContact();

    ContactEntity getContactByCid(Integer cid);

}
