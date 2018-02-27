package com.jyfw.jyfwser.controller;

import com.jyfw.jyfwser.pojo.em.ValidatorSatausEnum;
import com.jyfw.jyfwser.pojo.entity.UserEntity;
import com.jyfw.jyfwser.service.UserService;
import com.jyfw.jyfwser.util.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author: lulu
 * @description: 用户控制器
 * @date: created in 14:03 2018/2/27
 */
@Controller
public class UserCtroller {

    @Autowired
    private UserService userService;

    @PostMapping(value = "registerUser")
    public ModelAndView registerUser(@ModelAttribute("user")UserEntity user,
                                     @RequestParam("imgValidatorCode") String imgValidatorCode,
                                     HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        String sessionImgValidatorCode = (String) session.getAttribute("imgValidatorCode");
        if (!sessionImgValidatorCode.equals(imgValidatorCode)) {
            modelAndView.addObject("info", "错误的验证码");
            modelAndView.setViewName("register");
        } else {
            try {
                //插入用户信息，返回用户id
                //密码加密
                String pwd_sha256 = SHA256.transformWithSHA256(user.getPassword());
                user.setPassword(pwd_sha256);
                user.setStatus(ValidatorSatausEnum.UNVALIDATOR.getCode());
                userService.insertUser(user);
                //将用户信息置入session
                session.setAttribute("user", user);
                //TODO 将token插入到redis中
                String token = UUID.randomUUID().toString();

                //密码置空，将user放入session
                user.setPassword(null);
                session.setAttribute("user", user);
            }catch (Exception e) {
                System.out.println("用户注册失败..." + e);
            }
            modelAndView.addObject("userLogin", "true");
            modelAndView.addObject("user", user);

            modelAndView.setViewName("redirect:/index");
        }
        return modelAndView;
    }

    @PostMapping(value = "loginUser")
    public ModelAndView loginUser(HttpServletRequest request,
                                  @RequestParam("phone") String phone, @RequestParam("password") String passworod,
                                  @RequestParam("imgValidatorCode")String imgValidatorCode) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        String sessionImgValidatorCode = (String)session.getAttribute("imgValidatorCode");
        if (!sessionImgValidatorCode.equals(imgValidatorCode)) {
            modelAndView.addObject("imgValidatorInfo", "错误的验证码");
            modelAndView.setViewName("login");
        }else {
            String sha256_password = SHA256.transformWithSHA256(passworod);
            UserEntity user = userService.userLogin(phone, sha256_password);
            if(null == user) {
                modelAndView.addObject("loginInfo", "用户名或密码不正确！");
                modelAndView.setViewName("redirect:/login");
            }else {
                session.setAttribute("user", user);
                modelAndView.addObject("userLogin", "true");
                modelAndView.setViewName("redirect:/index");
            }
        }
        return modelAndView;
    }

}
