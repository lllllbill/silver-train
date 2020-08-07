package com.silverTrain.schedule.quartZ;

import javax.annotation.PostConstruct;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;

import com.silverTrain.common.entity.ScheduleJob;

import lombok.extern.slf4j.Slf4j;

/**
 * 
* @Title: QuartZOperate.java
* @Package com.silverTrain.schedule.quartZ
* @Description: quartZ操作类
* @author Bill
* @date 2020年7月1日
* @version V1.0
 */
@Slf4j
public class QuartZOperate {
	private static Scheduler Scheduler ;
	
	@Autowired
	private Scheduler scheduler;
	 
    @PostConstruct
    public void init(){
        this.Scheduler = scheduler;
    }
    
	public static void addJob(ScheduleJob job) throws SchedulerException{

	    if (job == null || !ScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
	      return;
	    }

	    Scheduler scheduler = Scheduler;
	    log.debug(scheduler + "...........................................add");
	    TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());

	    CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

	    // 不存在，创建一个
	    if (null == trigger) {
	      Class clazz = ScheduleJob.CONCURRENT_IS.equals(job.getIsConcurrent()) ? QuartzJobFactory.class
	                                                                           : QuartzJobFactoryDisallowConcurrentExecution.class;

	      JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).usingJobData("data", job.getJobData()).build();

	      jobDetail.getJobDataMap().put("scheduleJob", job);

	      CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

	      trigger = TriggerBuilder.newTrigger().withDescription(job.getJobId().toString()).withIdentity(job.getJobName(), job.getJobGroup())
	          .withSchedule(scheduleBuilder).build();

	      scheduler.scheduleJob(jobDetail, trigger);
	    } else {
	      // Trigger已存在，那么更新相应的定时设置
	      CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

	      // 按新的cronExpression表达式重新构建trigger
	      trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).usingJobData("data", job.getJobData()).withSchedule(scheduleBuilder).build();

	      // 按新的trigger重新设置job执行
	      scheduler.rescheduleJob(triggerKey, trigger);
	    }
	  
	}
}
