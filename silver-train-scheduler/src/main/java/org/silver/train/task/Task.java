package org.silver.train.task;

public abstract class Task {
	private TemporalFrequency temporalFrequency;
	
	private TaskType taskType;
	
	public TemporalFrequency getTemporalFrequency(){
		return this.temporalFrequency;
	}
	
	public TaskType getTaskType(){
		return this.taskType;
	}
}
