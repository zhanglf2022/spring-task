package com.lingoace.task.task;

import com.lingoace.task.entity.LessonPreparationInfo;
import com.lingoace.task.mapper.LessonPreparationInfoMapper;
import com.lingoace.task.service.LessonPreparationInfoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * [任务调度中心]
 *
 * @author zhanglifeng
 * @date 2020-04-14
 */
@Component
public class LingoAceTestTask extends QuartzJobBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(LingoAceTestTask.class);

    @Resource
    private LessonPreparationInfoService lessonPreparationInfoService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            LOGGER.info("------------------任务开始--------");
            LessonPreparationInfo lessonPreparationInfo = lessonPreparationInfoService.getById(1);
            LOGGER.info(lessonPreparationInfo.toString());
            LOGGER.info("------------------任务结束--------");
        } catch (Exception e) {
            LOGGER.error("出错:{}", e);
        }
    }
}
