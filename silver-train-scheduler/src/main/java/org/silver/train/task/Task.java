package org.silver.train.task;

import java.util.List;

/*
 * 抽象任务类
 */
public class Task {
	//时间表达式
	private TemporalFrequency temporalFrequency;
	//任务类型（用枚举感觉不是很好扩展）
	private TaskType taskType;
	//任务内容（网页A或者网页B）
	private List<String> taskContent;
	//任务等级
	private String taskRank;
	//任务操作
	private String taskOption;
	public TemporalFrequency getTemporalFrequency() {
		return temporalFrequency;
	}
	public void setTemporalFrequency(TemporalFrequency temporalFrequency) {
		this.temporalFrequency = temporalFrequency;
	}
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	public List<String> getTaskContent() {
		return taskContent;
	}
	public void setTaskContent(List<String> taskContent) {
		this.taskContent = taskContent;
	}
	public String getTaskRank() {
		return taskRank;
	}
	public void setTaskRank(String taskRank) {
		this.taskRank = taskRank;
	}
	public String getTaskOption() {
		return taskOption;
	}
	public void setTaskOption(String taskOption) {
		this.taskOption = taskOption;
	}
}
