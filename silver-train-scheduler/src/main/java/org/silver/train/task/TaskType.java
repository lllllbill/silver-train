package org.silver.train.task;

public enum TaskType {
	//任务列表
	//聚合任务，订阅任务
	POLYMERIZATIONTASK("POLYMERIZATIONTASK"),SUBSCRIBETASK("SUBSCRIBETASK");
;
	
	public String taskType;
	
	TaskType(String taskType){
		this.taskType = taskType;
	}
}
