package org.example;

import org.quartz.Scheduler;

public class SchedulerServiceImpl extends ScheduleService{

    private ScheduleDetailsRepository scheduleDetailsRepository;
    private Scheduler scheduler;

    public SchedulerServiceImpl(ScheduleDetailsRepository scheduleDetailsRepository,Scheduler scheduler){
        this.scheduleDetailsRepository = scheduleDetailsRepository;
        this.scheduler = scheduler;
    }
}
