package com.silverTrain.schedule.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 
* @Title: SpiderJob.java
* @Package com.silverTrain.schedule.job
* @Description: quartz spider job
* @author Bill
* @date 2020年8月28日
* @version V1.0
 */
public class SpiderJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		String taskId = dataMap.getString("taskId");
		//检查该任务是否已经被爬取
		
	}

}
