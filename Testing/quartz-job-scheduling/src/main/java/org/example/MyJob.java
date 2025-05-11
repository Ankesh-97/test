package org.example;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ScheduledActionService scheduledActionService = SpringBeanFactory.getBean(ScheduledActionService.class);
        scheduledActionService.execute();
    }
}
