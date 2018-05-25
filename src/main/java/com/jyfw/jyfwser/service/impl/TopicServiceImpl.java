package com.jyfw.jyfwser.service.impl;

import com.github.pagehelper.PageHelper;
import com.jyfw.jyfwser.mapper.TopicMapper;
import com.jyfw.jyfwser.pojo.entity.TopicEntity;
import com.jyfw.jyfwser.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public Integer insertTopic(TopicEntity topic) {
        return topicMapper.insertTopic(topic);
    }

    @Override
    public List<TopicEntity> listTopic(Integer page, Integer count, String topicName) {
        PageHelper.startPage(page, count);
        if(topicName == "") {
            topicName = null;
        }
        return topicMapper.listTopic(topicName);
    }

    @Override
    public TopicEntity getTopicById(Integer topicId) {
        return topicMapper.getTopicById(topicId);
    }
}
