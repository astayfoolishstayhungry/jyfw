package com.jyfw.jyfwser.mapper;

import com.jyfw.jyfwser.pojo.entity.ConfirmDemandEntity;
import com.jyfw.jyfwser.pojo.entity.DemandEntity;
import com.jyfw.jyfwser.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 需求dao
 * @date: created in 15:45 2018/4/29
 */
public interface DemandMapper {

    /**
     * 添加需求
     * @param demand
     * @return 需求id
     */
    Integer addDemand(DemandEntity demand);

    /**
     * 根据需求状态列举demand
     * @param status
     * @return
     */
    List<DemandEntity> listDemandByStatus(@Param("status") Integer status, @Param("dealObject") String dealObject);

    ConfirmDemandEntity getDemandByDemandId(Integer demandId);

}
