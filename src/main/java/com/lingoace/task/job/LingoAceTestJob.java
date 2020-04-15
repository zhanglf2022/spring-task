package com.lingoace.task.job;

import com.lingoace.task.task.LingoAceTestTask;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

/**
 * [定时任务触发器]
 *
 * @author zhanglifeng
 * @date 2020-04-14
 */
@Component
public class LingoAceTestJob {

    @Bean(name = "jobLingoAceTestTrigger")
    public CronTriggerFactoryBean jobLingoAceTestTrigger(@Qualifier("jobLingoAceTestDetail") JobDetail jobDetail) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetail);
        cronTriggerFactoryBean.setCronExpression("0 0/3 * * * ?");
        return cronTriggerFactoryBean;
    }

    @Bean(name = "jobLingoAceTestDetail")
    public JobDetailFactoryBean jobLingoAceTestDetail() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(LingoAceTestTask.class);
        jobDetailFactoryBean.setDurability(true);
        jobDetailFactoryBean.setRequestsRecovery(true);
        return jobDetailFactoryBean;
    }

}
