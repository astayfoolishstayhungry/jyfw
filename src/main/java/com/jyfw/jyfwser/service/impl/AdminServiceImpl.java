package com.jyfw.jyfwser.service.impl;

import com.jyfw.jyfwser.mapper.AdminMapper;
import com.jyfw.jyfwser.pojo.entity.AdminEntity;
import com.jyfw.jyfwser.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public AdminEntity adminLogin(String adminName, String password) {
        return adminMapper.getAdminByPhoneAndPassword(adminName, password);
    }

    @Override
    public AdminEntity getAdminByDemandId(Integer demandId) {
        return null;
    }

    @Override
    public List<AdminEntity> listAdmin() {
        return adminMapper.listAdmin();
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        adminMapper.deleteAdmin(adminId);
    }

    @Override
    public void insertAdmin(AdminEntity admin) {
        adminMapper.insertAdmin(admin);
    }
}
