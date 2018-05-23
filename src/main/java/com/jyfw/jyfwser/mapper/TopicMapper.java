package com.jyfw.jyfwser.mapper;

import com.jyfw.jyfwser.pojo.entity.TopicEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper {

    Integer insertTopic(TopicEntity topic);

    List<TopicEntity> listTopic(@Param("topicName") String topicName);

}
