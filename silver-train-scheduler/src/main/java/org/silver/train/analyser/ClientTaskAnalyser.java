package org.silver.train.analyser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.silver.train.task.Task;
import org.silver.train.task.TaskType;


public class ClientTaskAnalyser extends AbstractAnalyser{
	
	Map<TaskType,TaskAnalysisStrategy> matchingBeans;

	@Override
	public List<Task> analyserTask(Task task) {
		Task taskTemp = task;
		List<Task> taskList = new ArrayList<Task>();
		//接受任务，按照任务类型进行任务解析
		//用什么的设计模式？
		//模仿会员案例的设计模式
		//遍历针对各种任务的执行方法
		//还得有任务链
		//
		if (!matchingBeans.isEmpty()) {
            ArrayList<TaskAnalysisStrategy> discountStrategies = new ArrayList<>(matchingBeans.values());
            for (TaskAnalysisStrategy discountStrategy : discountStrategies) {
        		TaskType taskType= task.getTaskType();
                if (discountStrategy.supportType(taskType)) {
                	taskList.addAll(discountStrategy.taskAnalySis(task));
                }
            }
        }else{
        	//是要捕获错误还是？
        }
		return taskList;
	}
	

}
