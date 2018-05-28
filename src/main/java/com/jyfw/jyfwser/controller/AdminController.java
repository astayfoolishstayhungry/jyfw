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
    public ModelAndView getAdminPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admin = (AdminEntity) session.getAttribute("admin");
        if(null == admin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        List<DemandEntity> demands = demandService.listDemand();
        modelAndView.addObject("demands", demands);
        modelAndView.setViewName("adminpage");
        return modelAndView;
    }

    @GetMapping(value = "/admintopic")
    public ModelAndView getAdmintopicPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admin = (AdminEntity) session.getAttribute("admin");
        if(null == admin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        List<TopicEntity> topics = topicService.listAllTopic();
        modelAndView.addObject("topics", topics);
        modelAndView.setViewName("admintopic");
        return modelAndView;
    }

    @GetMapping(value = "/admincomments")
    public ModelAndView getAdmincommentsPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admin = (AdminEntity) session.getAttribute("admin");
        if(null == admin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        List<CommentEntity> comments = commentService.listComment();
        modelAndView.addObject("comments", comments);
        modelAndView.setViewName("admincomments");
        return modelAndView;
    }

    @GetMapping(value = "/adminerlist")
    public ModelAndView getAdminerlistPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admin = (AdminEntity) session.getAttribute("admin");
        if(null == admin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        List<AdminEntity> admins = adminService.listAdmin();
        modelAndView.addObject("admins", admins);
        modelAndView.setViewName("adminerlist");
        return modelAndView;
    }

    @GetMapping(value = "/adminerdelete")
    public ModelAndView getAdminerdeletePage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admin = (AdminEntity) session.getAttribute("admin");
        if(null == admin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        List<AdminEntity> admins = adminService.listAdmin();
        modelAndView.addObject("admins", admins);
        modelAndView.setViewName("adminerlist");
        return modelAndView;
    }

    @GetMapping(value = "deleteDemand")
    public ModelAndView delteDemandByDemandId(Integer demandId, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admin = (AdminEntity) session.getAttribute("admin");
        if(null == admin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        demandService.updateDemandCancelByDemandId(demandId);
        modelAndView.setViewName("redirect:/adminpage");
        return modelAndView;
    }

    @GetMapping(value = "deleteTopic")
    public ModelAndView delteTopicByTopicId(Integer topicId, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admin = (AdminEntity) session.getAttribute("admin");
        if(null == admin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        topicService.delteTopicByTid(topicId);
        modelAndView.setViewName("redirect:/admintopic");
        return modelAndView;
    }

    @GetMapping(value = "deleteComment")
    public ModelAndView delteCommentByCommentId(Integer CommentId, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admin = (AdminEntity) session.getAttribute("admin");
        if(null == admin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        commentService.deleteComment(CommentId);
        modelAndView.setViewName("redirect:/admincomments");
        return modelAndView;
    }

    @GetMapping(value = "/admineradd")
    public ModelAndView getAdmineraddPage(Model model, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admin = (AdminEntity) session.getAttribute("admin");
        if(null == admin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        model.addAttribute("admin", new AdminEntity());
        modelAndView.setViewName("admineradd");
        return modelAndView;
    }

    @GetMapping(value = "/deleteAdmin")
    public ModelAndView deleteAdmin(Integer adminId, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admin = (AdminEntity) session.getAttribute("admin");
        if(null == admin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        adminService.deleteAdmin(adminId);
        modelAndView.setViewName("redirect:/adminerlist");
        return modelAndView;
    }

    @PostMapping(value = "/adminadd")
    public ModelAndView insertAdmin(AdminEntity admin, HttpSession session) {
        AdminEntity currentAdmin = (AdminEntity) session.getAttribute("admin");
        ModelAndView modelAndView = new ModelAndView();
        if(null == currentAdmin) {
            modelAndView.setViewName("signin");
            return modelAndView;
        }
        String sha256_password = SHA256.transformWithSHA256(admin.getPassword());
        admin.setPassword(sha256_password);
        admin.setStatus(1);
        adminService.insertAdmin(admin);
        modelAndView.setViewName("adminerlist");
        return modelAndView;
    }

    @GetMapping(value = "/adminlogout")
    public String adminLogout(HttpSession session) {
        session.removeAttribute("admin");
        return "/signin";
    }

}
