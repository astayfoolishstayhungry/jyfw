package com.jyfw.jyfwser.controller;

import com.github.pagehelper.PageInfo;
import com.jyfw.jyfwser.pojo.entity.TopicEntity;
import com.jyfw.jyfwser.pojo.entity.UserEntity;
import com.jyfw.jyfwser.service.TopicService;
import com.jyfw.jyfwser.util.JsonResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping(value = "/inserttopic")
    public ModelAndView insertTopic(HttpSession session, TopicEntity topic) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        topic.setUid(user.getUid());
        //0 过期， 1 正常
        topic.setStatus(1);
        Integer count = topicService.insertTopic(topic);
        return new ModelAndView("redirect:/topic");
    }

    @PostMapping(value = "/topics")
    @ResponseBody
    public JsonResult listTopic(Integer page, Integer count, String topicName) {
        List<TopicEntity> topicEntities = topicService.listTopic(page, count,topicName);
        PageInfo pageInfo = new PageInfo(topicEntities);
        return JsonResult.createBySuccess(pageInfo);
    }

    @PostMapping(value = "/mytopics")
    @ResponseBody
    public JsonResult listTopic(HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        List<TopicEntity> topicEntities = topicService.listTopicByUid(user.getUid());
        PageInfo pageInfo = new PageInfo(topicEntities);
        return JsonResult.createBySuccess(pageInfo);
    }

}
