package com.jyfw.jyfwser.mapper;

import com.jyfw.jyfwser.pojo.entity.CommentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    Integer insertComment(CommentEntity comment);

    List<CommentEntity> listCommentByObjectId(Integer objectId);

    List<CommentEntity> listAllComment();

    void updateCommentStatusByCid(@Param("cid") Integer cid, @Param("status") Integer status);
}
