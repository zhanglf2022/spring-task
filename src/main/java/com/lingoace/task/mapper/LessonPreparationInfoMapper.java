package com.lingoace.task.mapper;


import com.lingoace.task.entity.LessonPreparationInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LessonPreparationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LessonPreparationInfo record);

    int insertSelective(LessonPreparationInfo record);

    LessonPreparationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LessonPreparationInfo record);

    int updateByPrimaryKey(LessonPreparationInfo record);
}