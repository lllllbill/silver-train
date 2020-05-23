package org.silver.train.task;

import java.util.List;
import java.util.Set;

import org.silver.train.schema.Target;
import org.silver.train.schema.User;

/*
 * 抽象任务类
 */
public class Task {
	//时间表达式
	private TemporalFrequency temporalFrequency;
	//任务类型（用枚举感觉不是很好扩展）
	private TaskType taskType;
	//任务内容 
	private Set<Target> targetSet;
	//任务等级
	private int taskRank;
	//任务操作
	private String taskOption;
	//用户
	private User user;
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
	public int getTaskRank() {
		return taskRank;
	}
	public void setTaskRank(int taskRank) {
		this.taskRank = taskRank;
	}
	public String getTaskOption() {
		return taskOption;
	}
	public void setTaskOption(String taskOption) {
		this.taskOption = taskOption;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Target> getTaskTarget() {
		return targetSet;
	}
	public void setTaskTarget(Set<Target> taskTarget) {
		this.targetSet = taskTarget;
	}
}
