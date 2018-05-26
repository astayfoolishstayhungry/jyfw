package com.jyfw.jyfwser.controller;

import com.github.pagehelper.PageInfo;
import com.jyfw.jyfwser.pojo.entity.DemandEntity;
import com.jyfw.jyfwser.pojo.entity.UserEntity;
import com.jyfw.jyfwser.pojo.vo.DemandVO;
import com.jyfw.jyfwser.service.DemandService;
import com.jyfw.jyfwser.service.UserService;
import com.jyfw.jyfwser.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 需求控制器
 * @date: created in 22:30 2018/5/22
 */
@RestController
public class RestDemandController {

    @Autowired
    private DemandService demandService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/demands")
    public JsonResult getDemands(HttpSession session,Integer page, Integer count, Integer status, String category, String dealObject) {
        UserEntity currentUser = (UserEntity) session.getAttribute("user");
        List<DemandEntity> demands = demandService.listDemandByStatus(page, count, status, category, dealObject);
        Iterator<DemandEntity> iterator = demands.iterator();
        while (iterator.hasNext()) {
            DemandEntity nextDemand = iterator.next();
            if(nextDemand.getUid().equals(currentUser.getUid())) {
                iterator.remove();
            }
        }
        List<DemandVO> demandVOS = new ArrayList<>();
        for (DemandEntity demand : demands) {
            DemandVO demandVO = new DemandVO();
            UserEntity user = userService.getUserByDemandId(demand.getId());
            demandVO.setId(demand.getId());
            demandVO.setUid(demand.getUid());
            demandVO.setUsername(user.getName());
            demandVO.setCategory(demand.getCategory());
            demandVO.setDealNum(demand.getDealNum());
            demandVO.setDealPrice(demand.getDealPrice());
            demandVO.setStatus(demand.getStatus());
            demandVO.setDealTimeFormat(demand.getDealTimeFormat());
            demandVO.setDealObject(demand.getDealObject());
            demandVO.setDealTime(demand.getDealTime());
            demandVOS.add(demandVO);
        }
        PageInfo pageInfo = new PageInfo(demandVOS);
        return JsonResult.createBySuccess(pageInfo);
    }


}
