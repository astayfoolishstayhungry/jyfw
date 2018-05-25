package com.jyfw.jyfwser.controller;

import com.alibaba.fastjson.JSONObject;
import com.jyfw.jyfwser.pojo.Const;
import com.jyfw.jyfwser.pojo.em.DemandStatusEnum;
import com.jyfw.jyfwser.pojo.entity.*;
import com.jyfw.jyfwser.pojo.vo.JuHeData;
import com.jyfw.jyfwser.pojo.vo.JuHeResult;
import com.jyfw.jyfwser.pojo.vo.NewsVO;
import com.jyfw.jyfwser.service.DemandService;
import com.jyfw.jyfwser.util.DateUtil;
import com.jyfw.jyfwser.util.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
            modelAndView.setViewName("demand");
        }else {
            modelAndView.addObject("errorInfo","请先登录！");
            modelAndView.setViewName("login");
        }

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
        String data = HttpUtils.sendGet(Const.JUHE_CAIJING_NEWS_API);
        JuHeData juHeData = JSONObject.parseObject(data, JuHeData.class);
        JuHeResult juheNews = juHeData.getResult();
        List<NewsVO> news = new ArrayList<>();
        news = juheNews.getData();
        modelAndView.addObject("news", news);
        modelAndView.setViewName("news");
        return modelAndView;
    }

    @GetMapping(value = "/contact")
    public ModelAndView getContactPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("contact");
        return modelAndView;
    }

    @GetMapping(value = "/contactdetail")
    public ModelAndView getContactDetailPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("contactdetail");
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
            List<DemandEntity> savedDemands = demandService.listDemandByStatus(null,null,DemandStatusEnum.UNVALIDATOR.getCode(), null);
            for (DemandEntity demand : savedDemands) {
                demand.setDealTimeFormat(DateUtil.parseDateToStr(demand.getDealTime(), DateUtil.DATE_TIME_FORMAT_YYYYMMDD));
            }
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

    @GetMapping(value = "/mycontact")
    public ModelAndView getMyContactPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user ) {
            List<DemandEntity> savedDemands = demandService.listDemandByStatus(null, null,DemandStatusEnum.UNVALIDATOR.getCode(), null);
            for (DemandEntity demand : savedDemands) {
                demand.setDealTimeFormat(DateUtil.parseDateToStr(demand.getDealTime(), DateUtil.DATE_TIME_FORMAT_YYYYMMDD));
            }
            //TODO 列举其他状态的需求
            modelAndView.addObject("savedDemands", savedDemands);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("mycontact");
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

    @GetMapping(value = "/topicadd")
    public ModelAndView getTopicAdd(Model model, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user ) {
            model.addAttribute("topic", new TopicEntity());
            modelAndView.addObject("user", user);
            modelAndView.setViewName("topicadd");
        }else {
            modelAndView.addObject("errorInfo","请先登录！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @GetMapping(value = "/topicdiscuss")
    public ModelAndView getTopicDiscuss(Model model, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user ) {
            model.addAttribute("comment", new CommentEntity());
            modelAndView.addObject("user", user);
            modelAndView.setViewName("topicdiscuss");
        }else {
            modelAndView.addObject("errorInfo","请先登录！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @GetMapping(value = "/mypage")
    public ModelAndView getMyPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user ) {

            modelAndView.addObject("user", user);
            modelAndView.setViewName("mypage");
        }else {
            modelAndView.addObject("errorInfo","请先登录！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @GetMapping(value = "/mytopic")
    public ModelAndView getMyTopic(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user ) {

            modelAndView.addObject("user", user);
            modelAndView.setViewName("mytopic");
        }else {
            modelAndView.addObject("errorInfo","请先登录！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @GetMapping(value = "/topic")
    public ModelAndView getTopic(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user ) {

            modelAndView.addObject("user", user);
            modelAndView.setViewName("topic");
        }else {
            modelAndView.addObject("errorInfo","请先登录！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @GetMapping(value = "/confirmdemand")
    public ModelAndView getConfirmDemand(HttpSession session, Integer demandId) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user ) {
            ConfirmDemandEntity confirmDemand = demandService.getDemandByDemandId(demandId);
            modelAndView.addObject("confirmDemand",confirmDemand);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("confirmdemand");
        }else {
            modelAndView.addObject("errorInfo","请先登录！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

}
