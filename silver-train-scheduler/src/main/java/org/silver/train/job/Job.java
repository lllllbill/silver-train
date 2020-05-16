package org.silver.train.job;

import java.util.List;

import org.silver.train.task.TemporalFrequency;


public class Job {
	private static String SPIDER = "spider";
	private static String SEND = "send";
	
	//时间表达式
	private TemporalFrequency temporalFrequency;
	//任务类型
	private String jobType;
	//任务内容（网页A或者网页B）
	//用schema
	private List<String> content;
	//任务操作类型
	private String option;
	//目标
	private String user;
	public TemporalFrequency getTemporalFrequency() {
		return temporalFrequency;
	}
	public void setTemporalFrequency(TemporalFrequency temporalFrequency) {
		this.temporalFrequency = temporalFrequency;
	}
}
