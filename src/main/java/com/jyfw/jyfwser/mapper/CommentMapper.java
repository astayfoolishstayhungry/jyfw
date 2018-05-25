package com.jyfw.jyfwser.mapper;

import com.jyfw.jyfwser.pojo.entity.CommentEntity;

import java.util.List;

public interface CommentMapper {

    Integer insertComment(CommentEntity comment);

    List<CommentEntity> listCommentByObjectId(Integer objectId);
}
