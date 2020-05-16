package org.silver.train.analyser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.silver.train.job.Job;
import org.silver.train.task.Task;
import org.silver.train.task.TaskType;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/*
 * 任务解析器
 */
public class ClientTaskAnalyser extends AbstractAnalyser{
	
	@Autowired
    ApplicationContext context;
	
	Map<String,TaskAnalysisStrategy> matchingBeans;
	
	public ClientTaskAnalyser(){
		this.matchingBeans = 
				BeanFactoryUtils.beansOfTypeIncludingAncestors(context, TaskAnalysisStrategy.class, true, false);
	}
	
	@Override
	public List<Job> analyserTask(Task task) {
		if(task == null||matchingBeans == null){
			throw new NullPointerException("task or matchingBeans can not be null");
		}
		List<Job> taskList = new ArrayList<Job>();
		if (!matchingBeans.isEmpty()) {
            ArrayList<TaskAnalysisStrategy> discountStrategies = new ArrayList<>(matchingBeans.values());
            for (TaskAnalysisStrategy discountStrategy : discountStrategies) {
        		TaskType taskType= task.getTaskType();
                if (discountStrategy.supportType(taskType)) {
                	taskList.addAll(discountStrategy.taskAnalySis(task));
                }
            }
        }
		return taskList;
	}

}
