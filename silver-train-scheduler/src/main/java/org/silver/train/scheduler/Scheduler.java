package org.silver.train.scheduler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import org.silver.train.analyser.Analyser;
import org.silver.train.analyser.ClientTaskAnalyser;
import org.silver.train.excutor.Excutor;
import org.silver.train.excutor.XXLJOBExcutor;
import org.silver.train.job.Job;
import org.silver.train.task.Task;

public class Scheduler{
	
	public static int interval = 30;
	public static TimeUnit timeUnit =TimeUnit.MINUTES;
	
    protected final static int STAT_INIT = 0;

    protected final static int STAT_RUNNING = 1;

	protected final static int STAT_STOPPED = 2;
    
	protected int state = 0 ;
	protected Analyser analyser;
	protected Excutor excutor;
	
	private List<LinkedTask> taskArray;
	
	//单例模式也是要有构造函数
	public Scheduler(){
		this.analyser = new ClientTaskAnalyser();
		this.excutor = new XXLJOBExcutor();
		setTaskArray();
	}
	
	public Scheduler(Analyser analyser){
		this.analyser = analyser;
		this.excutor = new XXLJOBExcutor();
		setTaskArray();
	}
	
	public Scheduler(Analyser analyser,Excutor excutor){
		this.analyser = analyser;
		this.excutor = excutor;
		setTaskArray();
	}
	
	public boolean addNewTask(Task task){
		//检查组件
		checkAndInitComponent();
		//开始任务合并操作
		List<Job> newListJob = analyser.analyserTask(task);
		//找到对应任务刻度上的任务链
		//对相同的任务进行任务合并或者分隔操作
		//合并任务
		//任务分隔操作
		//一种任务存
		for(Job job:newListJob){
			
		}
		return false;
	}
	//检查组件
	private void checkAndInitComponent(){
		if(this.analyser == null){
			this.analyser = new ClientTaskAnalyser();
		}
	}
	//获取taskArray
	private void setTaskArray(){
		taskArray = new CopyOnWriteArrayList<LinkedTask>();
	}
}
