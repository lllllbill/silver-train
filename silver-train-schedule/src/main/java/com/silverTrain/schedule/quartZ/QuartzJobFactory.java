package com.silverTrain.schedule.quartZ;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.silverTrain.common.entity.ScheduleJob;
import com.silverTrain.common.unit.TaskUtils;


/**
 * 
* @Title: QuartzJobFactory.java
* @Package com.silverTrain.schedule.entity
* @Description: 计划任务执行处 无状态
* @author Bill
* @date 2020年7月1日
* @version V1.0
 */
public class QuartzJobFactory implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		TaskUtils.invokMethod(scheduleJob);
	}
}