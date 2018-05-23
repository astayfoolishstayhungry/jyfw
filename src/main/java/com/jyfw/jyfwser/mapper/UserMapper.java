package com.jyfw.jyfwser.mapper;

import com.jyfw.jyfwser.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @description: 用户相关dao
 * @date: created in 0:41 2018/2/27
 */
public interface UserMapper {

    /**
     * 用户注册
     * @param user 用户
     * @return 用户主键
     */
    Integer insertUser(UserEntity user);

    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    UserEntity getUserByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

    UserEntity getUserByDemandId(Integer demandId);

}
