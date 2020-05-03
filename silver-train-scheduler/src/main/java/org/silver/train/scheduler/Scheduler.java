package org.silver.train.scheduler;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.silver.train.analyser.Analyser;
import org.silver.train.task.Task;

public class Scheduler{
	
	protected final static int INTERVAL = 30;
	protected  static TimeUnit TIMEUNIT;
	
	protected Analyser analyser;
	
	private List<LinkedTask> taskArray;
	
	
	public Scheduler(){
		
	}
	
	public boolean addNewTask(Task task){
		//获取对应时间刻度上的任务链表
		//从任务链表中获取相同类型任务
		//合并任务
		Task taskTemp = task;
		return false;
	}
	
}
