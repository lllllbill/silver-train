package org.silver.train.analyser;

import java.util.List;

import org.silver.train.job.Job;
import org.silver.train.task.Task;
import org.silver.train.task.TaskType;

public interface TaskAnalysisStrategy {
	TaskType taskType();
	
	boolean supportType(TaskType taskType);
	
	List<Job> taskAnalySis(Task task) throws Exception;
}
