package com.jyfw.jyfwser.service.impl;

import com.github.pagehelper.PageHelper;
import com.jyfw.jyfwser.mapper.DemandMapper;
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
    public List<DemandEntity> listDemandByStatus(Integer page, Integer count, Integer status, String dealObject) {
        if(page != null && count != null) {
            PageHelper.startPage(page, count);
        }
        List<DemandEntity> demands = demandMapper.listDemandByStatus(status, dealObject);
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
}
