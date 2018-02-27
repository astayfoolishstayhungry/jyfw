package com.jyfw.jyfwser.controller;

import com.jyfw.jyfwser.pojo.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: lulu
 * @description: 页面控制器
 * @date: created in 12:31 2018/2/27
 */
@Controller
public class PageController {

    @GetMapping(value = "/")
    public ModelAndView getHomePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("userLogin", "true");
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
            modelAndView.addObject("userLogin", "true");
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
            modelAndView.addObject("userLogin", "true");
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
            modelAndView.addObject("userLogin", "true");
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
            modelAndView.addObject("userLogin", "true");
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

}
