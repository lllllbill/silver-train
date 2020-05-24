package org.silver.train.analyser;

import java.util.ArrayList;
import java.util.List;

import org.silver.train.job.Job;
import org.silver.train.scheduler.Scheduler;
import org.silver.train.schema.Target;
import org.silver.train.task.Task;
import org.silver.train.task.TaskType;
import org.silver.train.task.TemporalFrequency;

public class SubscribeTaskAnalysisStrategy implements TaskAnalysisStrategy{
	private TaskType taskType =TaskType.SUBSCRIBETASK;
	
	@Override
	public TaskType taskType() {
		return this.taskType;
	}

	@Override
	public boolean supportType(TaskType taskType) {
		return this.taskType.equals(taskType);
	}

	@Override
	public List<Job> taskAnalySis(Task task) throws Exception{
		/**
		 * 新增订阅任务
		 * 根据时间间隔来生成爬虫任务
		 */
		List<TemporalFrequency> temporalFrequencyList = TemporalFrequency.getAllCycleTime(Scheduler.getInterval(), Scheduler.getTimeUnit());
		List<Job> result = null;
		if(task!=null){
			result = new ArrayList(TemporalFrequency.cycleCount(Scheduler.getInterval(), Scheduler.getTimeUnit()));
			for(TemporalFrequency temp:temporalFrequencyList){
				for(Target target:task.getTaskTarget()){
					Job job = new Job();
					job.setJobType(Job.SPIDER);
					job.setOption(task.getTaskOption());
					job.setUser(task.getUser());
					Class[] spiderClass = new Class[1];
					spiderClass[0] = Class.forName(target.getSpiderClassName());
					job.setTarget(spiderClass);
					job.setTemporalFrequency(temp);
				}
				
			}
		}
		return result;
	}
	
}
