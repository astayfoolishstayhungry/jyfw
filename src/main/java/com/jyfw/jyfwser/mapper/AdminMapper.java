package com.jyfw.jyfwser.mapper;

import com.jyfw.jyfwser.pojo.entity.AdminEntity;
import com.jyfw.jyfwser.pojo.entity.DemandEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 管理员相关dao
 * @date: created in 0:41 2018/2/27
 */
public interface AdminMapper {

    AdminEntity getAdminByPhoneAndPassword(@Param("adminName") String adminName, @Param("password") String password);

    AdminEntity getAdminByDemandId(Integer demandId);

    List<AdminEntity> listAdmin();

    void deleteAdmin(Integer adminId);

    void insertAdmin(AdminEntity admin);

}
