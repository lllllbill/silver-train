package com.silverTrain.schedule.quartZ;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.silverTrain.common.entity.ScheduleJob;
import com.silverTrain.common.unit.TaskUtils;


/**
 * 
* @Title: QuartzJobFactoryDisallowConcurrentExecution.java
* @Package com.silverTrain.schedule.entity
* @Description: 若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作
* @author Bill
* @date 2020年7月1日
* @version V1.0
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {

  public void execute(JobExecutionContext context) throws JobExecutionException {
      ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
      TaskUtils.invokMethod(scheduleJob);

  }
}