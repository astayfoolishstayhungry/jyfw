package com.jyfw.jyfwser.service.impl;

import com.jyfw.jyfwser.mapper.UserMapper;
import com.jyfw.jyfwser.pojo.entity.UserEntity;
import com.jyfw.jyfwser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: chunxiao
 * @description: 用户服务实现
 * @date: created in 0:50 2018/2/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insertUser(UserEntity user) {
        userMapper.insertUser(user);
        return user.getUid();
    }

    @Override
    public UserEntity userLogin(String phone, String password) {
        return userMapper.getUserByPhoneAndPassword(phone, password);
    }
}
