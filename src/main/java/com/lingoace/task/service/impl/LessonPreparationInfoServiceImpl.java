package com.lingoace.task.service.impl;

import com.lingoace.task.entity.LessonPreparationInfo;
import com.lingoace.task.mapper.LessonPreparationInfoMapper;
import com.lingoace.task.service.LessonPreparationInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class LessonPreparationInfoServiceImpl implements LessonPreparationInfoService {
    @Resource
    private LessonPreparationInfoMapper lessonPreparationInfoMapper;
    @Override
    public LessonPreparationInfo getById(Integer id) {
        return lessonPreparationInfoMapper.selectByPrimaryKey(id);
    }
}
