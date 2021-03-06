package com.jyfw.jyfwser.service.impl;

import com.github.pagehelper.PageHelper;
import com.jyfw.jyfwser.mapper.DemandMapper;
import com.jyfw.jyfwser.pojo.em.DemandStatusEnum;
import com.jyfw.jyfwser.pojo.entity.ConfirmDemandEntity;
import com.jyfw.jyfwser.pojo.entity.DemandEntity;
import com.jyfw.jyfwser.service.DemandService;
import com.jyfw.jyfwser.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description: 实现类
 * @date: created in 16:25 2018/4/29
 */
@Service
public class DemandServiceImpl implements DemandService {

    @Autowired
    private DemandMapper demandMapper;

    @Override
    @Transactional
    public Integer addDemand(DemandEntity demand) {
        Integer count = demandMapper.addDemand(demand);
        return demand.getId();
    }

    @Override
    public List<DemandEntity> listDemandByStatus(Integer page, Integer count, Integer status, String category,
                                                 String dealObject) {
        if(page != null && count != null) {
            PageHelper.startPage(page, count);
        }
        if(dealObject == "") {
            dealObject = null;
        }
        List<DemandEntity> demands = demandMapper.listDemandByStatus(status, dealObject, category);
        for (DemandEntity demand : demands) {
            Date dealTime = demand.getDealTime();
            if(null != dealTime) {
                demand.setDealTimeFormat(DateUtil.parseDateToStr(dealTime, DateUtil.DATE_TIME_FORMAT_YYYYMMDD));
            }else {
                continue;
            }
        }
        return demands;
    }

    @Override
    public ConfirmDemandEntity getDemandByDemandId(Integer demandId) {
        return demandMapper.getDemandByDemandId(demandId);
    }

    @Override
    public void updateDemandDoneByDemandId(Integer demandId) {
        demandMapper.updateDemandStatusByDid(demandId, DemandStatusEnum.VALIDATORING.getCode());
    }

    @Override
    public void updateDemandCancelByDemandId(Integer demandId) {
        demandMapper.updateDemandStatusByDid(demandId, DemandStatusEnum.VALIDATOR_FAILED.getCode());
    }


    @Override
    public List<DemandEntity> listDemand() {
        return demandMapper.listDemand();
    }

    @Override
    public List<DemandEntity> listDemandByUid(Integer uid) {
        return demandMapper.listDemandByUid(uid);
    }
}
