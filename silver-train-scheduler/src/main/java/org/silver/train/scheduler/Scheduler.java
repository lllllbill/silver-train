package org.silver.train.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import org.silver.train.analyser.Analyser;
import org.silver.train.analyser.ClientTaskAnalyser;
import org.silver.train.excutor.Excutor;
import org.silver.train.excutor.QuartZExcutor;
import org.silver.train.task.Task;
import org.silver.train.task.TaskType;
import org.silver.train.task.TemporalFrequency;

public class Scheduler{
	
	protected final static int INTERVAL = 30;
	protected static TimeUnit TIMEUNIT =TimeUnit.MINUTES ;
	
    protected final static int STAT_INIT = 0;

    protected final static int STAT_RUNNING = 1;

    protected final static int STAT_STOPPED = 2;
    
	protected int state = 0 ;
	protected Analyser analyser;
	protected Excutor excutor;
	
	private List<LinkedTask> spiderTaskArray = new CopyOnWriteArrayList<LinkedTask>();
	private List<LinkedTask> sendTaskArray = new CopyOnWriteArrayList<LinkedTask>();
	
	//要设置成单例模式吗？还是用spring的注入
	public Scheduler(){
		this.analyser = new ClientTaskAnalyser();
		this.excutor = new QuartZExcutor();
	}
	
	public boolean addNewTask(Task task){
		//获取对应时间刻度上的任务链表
		//从任务链表中获取相同类型任务
		//合并任务
		checkAndInitComponent();
		List<Task> completeTaskArray = analyser.analyserTask(task);
		List<Task> tasksToBePerformed = new ArrayList<Task>();
		LinkedTask existingLinkedTaskNode = null;
		for(Task completetask:completeTaskArray){
			//遍历取出相同类型，相同页面的任务
			if(completetask.getTaskType().equals(TaskType.SENDTASK)){
				existingLinkedTaskNode = sendTaskArray.get(calculation(completetask.getTemporalFrequency()));
			}else if(completetask.getTaskType().equals(TaskType.SPIDERTASK)){
				existingLinkedTaskNode = spiderTaskArray.get(calculation(completetask.getTemporalFrequency()));
			}
			tasksToBePerformed.addAll(mergeTask(existingLinkedTaskNode,completetask));
			excutor.excutorJobs(tasksToBePerformed);
		}
		return false;
	}
	//检查组件
	private void checkAndInitComponent(){
		if(this.analyser == null){
			this.analyser = new ClientTaskAnalyser();
		}
	}
	//计算时间
	private int calculation(TemporalFrequency TemporalFrequency){
		return 0;
	}
	//合并任务
	//要不要设计成接口类？
	private List<Task> mergeTask(LinkedTask linkedTaskNode,Task newTask){
		//返回为job会不会更好一点
		return null;
	}
}
