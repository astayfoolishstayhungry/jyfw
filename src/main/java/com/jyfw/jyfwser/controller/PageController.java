package com.jyfw.jyfwser.controller;

import com.jyfw.jyfwser.pojo.em.DemandStatusEnum;
import com.jyfw.jyfwser.pojo.entity.DemandEntity;
import com.jyfw.jyfwser.pojo.entity.UserEntity;
import com.jyfw.jyfwser.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description: 页面控制器
 * @date: created in 12:31 2018/2/27
 */
@Controller
public class PageController {

    @Autowired
    private DemandService demandService;

    @GetMapping(value = "/")
    public ModelAndView getHomePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }

    @GetMapping(value = "/index")
    public ModelAndView getIndexPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/demand")
    public ModelAndView getDemandPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("demand");
        return modelAndView;
    }

    @GetMapping(value = "/news")
    public ModelAndView getNewsPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("news");
        return modelAndView;
    }

    @GetMapping(value = "/statistic")
    public ModelAndView getStatisticPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("statistic");
        return modelAndView;
    }

    @GetMapping(value = "/login")
    public ModelAndView getLoginPage(Model model) {
        model.addAttribute("user", new UserEntity());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView getRegisterPage(Model model) {
        model.addAttribute("user", new UserEntity());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @GetMapping(value = "/mydemand")
    public ModelAndView getMyDemandPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user ) {
            List<DemandEntity> savedDemands = demandService.listDemandByStatus(DemandStatusEnum.UNVALIDATOR.getCode());
            //TODO 列举其他状态的需求
            modelAndView.addObject("savedDemands", savedDemands);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("mydemand");
        }else {
            modelAndView.addObject("errorInfo","请先登录！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @GetMapping(value = "/demandadd")
    public ModelAndView getContractPage(Model model, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("demand", new DemandEntity());
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
            modelAndView.setViewName("demandadd");
        }else {
            modelAndView.addObject("errorInfo","请先登录！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

}
