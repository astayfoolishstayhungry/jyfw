package com.jyfw.jyfwser.controller;

import com.jyfw.jyfwser.pojo.em.DemandStatusEnum;
import com.jyfw.jyfwser.pojo.entity.DemandEntity;
import com.jyfw.jyfwser.pojo.entity.UserEntity;
import com.jyfw.jyfwser.service.DemandService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

/**
 * @description: 需求控制器
 * @date: created in 12:00 2018/4/29
 */
@Controller
public class DemandController {

    @Autowired
    private DemandService demandService;

    @PostMapping(value = "/demandadd")
    public ModelAndView addDemand(DemandEntity demand, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        demand.setUid(user.getUid());
        demand.setStatus(DemandStatusEnum.VALIDATOR.getCode());
        Integer id = demandService.addDemand(demand);
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        if(null == id) {
            modelAndView.addObject("errorInfo", "系统内部错误");
            modelAndView.setViewName("demandadd");
        }
        modelAndView.setViewName("redirect:/demand");
        return modelAndView;
    }

}
