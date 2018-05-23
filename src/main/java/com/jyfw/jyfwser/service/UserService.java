package com.jyfw.jyfwser.service;

import com.jyfw.jyfwser.pojo.entity.UserEntity;

/**
 * @description: 用户服务相关接口
 * @date: created in 0:49 2018/2/27
 */
public interface UserService {

    /**
     * 用户注册
     * @param user 用户
     * @return 用户主键
     */
    Integer insertUser(UserEntity user);

    /**
     * 用戶登陸
     * @param phone
     * @param password
     * @return
     */
    UserEntity userLogin(String phone, String password);

    UserEntity getUserByDemandId(Integer demandId);

}
