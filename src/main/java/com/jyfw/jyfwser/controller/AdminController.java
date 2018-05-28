package com.jyfw.jyfwser.controller;

import com.jyfw.jyfwser.pojo.entity.*;
import com.jyfw.jyfwser.service.AdminService;
import com.jyfw.jyfwser.service.CommentService;
import com.jyfw.jyfwser.service.DemandService;
import com.jyfw.jyfwser.service.TopicService;
import com.jyfw.jyfwser.util.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private DemandService demandService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/adminpage")
    public ModelAndView getAdminPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        List<DemandEntity> demands = demandService.listDemand();
        modelAndView.addObject("demands", demands);
        modelAndView.setViewName("adminpage");
        return modelAndView;
    }

    @GetMapping(value = "/admintopic")
    public ModelAndView getAdmintopicPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        List<TopicEntity> topics = topicService.listAllTopic();
        modelAndView.addObject("topics", topics);
        modelAndView.setViewName("admintopic");
        return modelAndView;
    }

    @GetMapping(value = "/admincomments")
    public ModelAndView getAdmincommentsPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<CommentEntity> comments = commentService.listComment();
        modelAndView.addObject("comments", comments);
        modelAndView.setViewName("admincomments");
        return modelAndView;
    }

    @GetMapping(value = "/adminusers")
    public ModelAndView getAdminusersPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("adminusers");
        return modelAndView;
    }

    @GetMapping(value = "/adminerlist")
    public ModelAndView getAdminerlistPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<AdminEntity> admins = adminService.listAdmin();
        modelAndView.addObject("admins", admins);
        modelAndView.setViewName("adminerlist");
        return modelAndView;
    }



    @GetMapping(value = "/adminerdelete")
    public ModelAndView getAdminerdeletePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if(null != user) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("adminerdelete");
        return modelAndView;
    }

    @GetMapping(value = "deleteDemand")
    public ModelAndView delteDemandByDemandId(Integer demandId) {
        demandService.updateDemandCancelByDemandId(demandId);
        return new ModelAndView("redirect:/adminpage");
    }

    @GetMapping(value = "deleteTopic")
    public ModelAndView delteTopicByTopicId(Integer topicId) {
        topicService.delteTopicByTid(topicId);
        return new ModelAndView("admintopic");
    }

    @GetMapping(value = "deleteComment")
    public ModelAndView delteCommentByCommentId(Integer CommentId) {
        commentService.deleteComment(CommentId);
        return new ModelAndView("admincomments");
    }

    @GetMapping(value = "/admineradd")
    public ModelAndView getAdmineraddPage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("admin", new AdminEntity());
        modelAndView.setViewName("admineradd");
        return modelAndView;
    }

    @GetMapping(value = "/deleteAdmin")
    public ModelAndView deleteAdmin(Integer adminId) {
        adminService.deleteAdmin(adminId);
        return new ModelAndView("adminerlist");
    }

    @PostMapping(value = "/adminadd")
    public ModelAndView insertAdmin(AdminEntity admin) {
        String sha256_password = SHA256.transformWithSHA256(admin.getPassword());
        admin.setPassword(sha256_password);
        admin.setStatus(1);
        adminService.insertAdmin(admin);
        return new ModelAndView("adminerlist");
    }

}
