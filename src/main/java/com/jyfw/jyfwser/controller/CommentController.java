package com.jyfw.jyfwser.controller;

import com.jyfw.jyfwser.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/insertcomment")
    public ModelAndView insertComment() {
        return null;
    }

}
