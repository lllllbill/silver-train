package org.silver.train.job;

import java.util.List;

import org.silver.train.schema.Target;
import org.silver.train.schema.User;
import org.silver.train.task.TemporalFrequency;


public class Job {
	public static String SPIDER = "spider";
	public static String SEND = "send";
	
	//时间表达式
	private TemporalFrequency temporalFrequency;
	//任务类型
	private String jobType;
	//目标
	private Class[] target;
	//任务操作类型
	private String option;
	//目标
	private User user;
	public TemporalFrequency getTemporalFrequency() {
		return temporalFrequency;
	}
	public void setTemporalFrequency(TemporalFrequency temporalFrequency) {
		this.temporalFrequency = temporalFrequency;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Class[] getTarget() {
		return target;
	}
	public void setTarget(Class[] target) {
		this.target = target;
	}
}
