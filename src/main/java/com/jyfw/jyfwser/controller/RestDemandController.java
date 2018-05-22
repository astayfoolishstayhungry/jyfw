package com.jyfw.jyfwser.controller;

import com.github.pagehelper.PageInfo;
import com.jyfw.jyfwser.pojo.entity.DemandEntity;
import com.jyfw.jyfwser.service.DemandService;
import com.jyfw.jyfwser.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 需求控制器
 * @date: created in 22:30 2018/5/22
 */
@RestController
public class RestDemandController {

    @Autowired
    private DemandService demandService;

    @PostMapping(value = "/demands")
    public JsonResult getDemands(Integer page, Integer count, Integer status, String dealObject) {
        List<DemandEntity> demands = demandService.listDemandByStatus(page, count, status, dealObject);
        PageInfo pageInfo = new PageInfo(demands);
        return JsonResult.createBySuccess(pageInfo);
    }


}
