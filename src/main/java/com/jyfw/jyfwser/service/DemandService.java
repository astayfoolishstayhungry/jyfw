package com.jyfw.jyfwser.service;

import com.jyfw.jyfwser.pojo.entity.ConfirmDemandEntity;
import com.jyfw.jyfwser.pojo.entity.DemandEntity;

import java.util.List;

/**
 * @description: 需求服务类
 * @date: created in 16:24 2018/4/29
 */
public interface DemandService {

    /**
     * 新增需求
     * @param demand
     * @return
     */
    Integer addDemand(DemandEntity demand);

    /**
     * 根据需求状态列举demand
     * @param status
     * @return
     */
    List<DemandEntity> listDemandByStatus(Integer page, Integer count, Integer status,  String category, String dealObject);

    ConfirmDemandEntity getDemandByDemandId(Integer demandId);

    void updateDemandDoneByDemandId(Integer demandId);

    void updateDemandCancelByDemandId(Integer demandId);

    List<DemandEntity> listDemand();

    List<DemandEntity> listDemandByUid(Integer uid);

}
