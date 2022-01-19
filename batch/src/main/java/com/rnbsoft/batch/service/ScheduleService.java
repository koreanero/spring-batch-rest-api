package com.rnbsoft.batch.service;

import org.quartz.Job;
import org.quartz.JobKey;

import com.rnbsoft.batch.vo.JobRequest;
import com.rnbsoft.batch.vo.JobStatusResponse;

public interface ScheduleService {
    JobStatusResponse getAllJobs();

    boolean isJobRunning(JobKey jobKey);

    boolean isJobExists(JobKey jobKey);

//    boolean addJob(JobRequest jobRequest, Class<? extends QuartzJobBean> jobClass);

    boolean addJob(JobRequest jobRequest, Class<? extends Job> jobClass);

    boolean deleteJob(JobKey jobKey);

    boolean pauseJob(JobKey jobKey);

    boolean resumeJob(JobKey jobKey);

    String getJobState(JobKey jobKey);
}
