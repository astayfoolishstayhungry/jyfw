package com.jyfw.jyfwser.service;

import com.jyfw.jyfwser.pojo.entity.AdminEntity;
import com.jyfw.jyfwser.pojo.entity.UserEntity;

import java.util.List;

/**
 * @description: 用户服务相关接口
 * @date: created in 0:49 2018/2/27
 */
public interface AdminService {

    /**
     * 用戶登陸
     * @param phone
     * @param password
     * @return
     */
    AdminEntity adminLogin(String phone, String password);

    AdminEntity getAdminByDemandId(Integer demandId);

    List<AdminEntity> listAdmin();

    void deleteAdmin(Integer adminId);

    void insertAdmin(AdminEntity admin);

}
