package com.jyfw.jyfwser.service.impl;

import com.jyfw.jyfwser.mapper.CommentMapper;
import com.jyfw.jyfwser.pojo.entity.CommentEntity;
import com.jyfw.jyfwser.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Integer insertComment(CommentEntity comment) {
        Integer count = commentMapper.insertComment(comment);
        return count;
    }

    @Override
    public List<CommentEntity> listCommentByObject(Integer objectId) {
        return commentMapper.listCommentByObjectId(objectId);
    }

    @Override
    public List<CommentEntity> listComment() {
        return commentMapper.listAllComment();
    }

    @Override
    public void deleteComment(Integer cid) {
        commentMapper.updateCommentStatusByCid(cid, 2);
    }


}
