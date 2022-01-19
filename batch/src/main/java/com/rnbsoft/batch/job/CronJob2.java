package com.rnbsoft.batch.job;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CronJob2 implements Job {
	private int MAX_SLEEP_IN_SECONDS = 5;

	private volatile Thread currThread;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobKey jobKey = context.getJobDetail().getKey();
		currThread = Thread.currentThread();
		log.info("============================================================================");
		log.info("CronJob started :: sleep : {} jobKey : {} - {}", MAX_SLEEP_IN_SECONDS, jobKey, currThread.getName());

		IntStream.range(0, 10).forEach(i -> {
			log.info("CronJob Counting - {}", i);
			try {
				TimeUnit.SECONDS.sleep(MAX_SLEEP_IN_SECONDS);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
		});
		log.info("CronJob ended :: jobKey : {} - {}", jobKey, currThread.getName());
		log.info("============================================================================");
	}
}
