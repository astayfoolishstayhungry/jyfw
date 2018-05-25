package com.jyfw.jyfwser.service;

import com.jyfw.jyfwser.pojo.entity.CommentEntity;

import java.util.List;

public interface CommentService {

    Integer insertComment(CommentEntity comment);

    List<CommentEntity> listCommentByObject(Integer objectId);

}
