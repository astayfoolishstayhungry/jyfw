package com.jyfw.jyfwser.service.impl;

import com.jyfw.jyfwser.mapper.ContactMapper;
import com.jyfw.jyfwser.pojo.entity.ContactEntity;
import com.jyfw.jyfwser.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chunxiao
 * @description:
 * @date: created in 19:16 2018/5/26
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public void insertContact(ContactEntity contact) {
        contactMapper.insertContract(contact);
    }

    @Override
    public List<ContactEntity> listContactByUid(Integer uid) {
        return contactMapper.listContactByUid(uid);
    }

    @Override
    public List<ContactEntity> listContactLimitSix() {
        return contactMapper.listContactLimitSix();
    }
}
