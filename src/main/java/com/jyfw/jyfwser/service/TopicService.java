package com.jyfw.jyfwser.service;

import com.jyfw.jyfwser.pojo.entity.TopicEntity;

import java.util.List;

public interface TopicService {

    Integer insertTopic(TopicEntity topic);

    List<TopicEntity> listTopic(Integer page, Integer count, String topicName);

    TopicEntity getTopicById(Integer topicId);

}
