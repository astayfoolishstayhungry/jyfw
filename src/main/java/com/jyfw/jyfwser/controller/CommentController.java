package com.jyfw.jyfwser.controller;

import com.jyfw.jyfwser.pojo.em.CommentTypeEnum;
import com.jyfw.jyfwser.pojo.em.ValidatorSatausEnum;
import com.jyfw.jyfwser.pojo.entity.CommentEntity;
import com.jyfw.jyfwser.pojo.entity.UserEntity;
import com.jyfw.jyfwser.service.CommentService;
import com.jyfw.jyfwser.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/insertcomment")
    @ResponseBody
    public JsonResult insertComment(HttpSession session, Integer topicId, String content) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        CommentEntity comment = new CommentEntity();
        comment.setUid(user.getUid());
        comment.setCommentType(CommentTypeEnum.TOPIC.getCode());
        comment.setObjectId(topicId);
        comment.setContent(content);
        comment.setStatus(ValidatorSatausEnum.VALIDATOR.getCode());
        commentService.insertComment(comment);
        return JsonResult.createBySuccess();
    }

}
