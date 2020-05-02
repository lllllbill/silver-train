package org.silver.train.scheduler;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Scheduler{
	
	//时间间隔
	protected final static int INTERVAL = 30;
	//时间间隔单位
	protected  static TimeUnit timeUnit;
	
	private List<LinkedTask> taskArray;
	
	
	public Scheduler(){
		
	}
	
	public boolean addNewTask(Task task){
		//获取对应时间刻度上的任务链表
		//从任务链表中获取相同类型任务
		//合并任务
		return false;
	}
	
}
