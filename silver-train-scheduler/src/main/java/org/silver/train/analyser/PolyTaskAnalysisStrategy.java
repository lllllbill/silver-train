package org.silver.train.analyser;

import java.util.List;

import org.silver.train.task.Task;
import org.silver.train.task.TaskType;

public class PolyTaskAnalysisStrategy implements TaskAnalysisStrategy{

	private TaskType taskType =TaskType.POLYMERIZATION;
	
	@Override
	public TaskType taskType() {
		return this.taskType;
	}

	@Override
	public boolean supportType(TaskType taskType) {
		return this.taskType.equals(taskType);
	}

	@Override
	public List<Task> taskAnalySis(Task task) {
		return null;
	}

}
