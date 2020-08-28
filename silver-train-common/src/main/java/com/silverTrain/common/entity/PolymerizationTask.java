package com.silverTrain.common.entity;

import lombok.Data;

/**
 * 
* @Title: SpiderTask.java
* @Package com.silverTrain.common.entity
* @Description: 爬虫任务表
* @author Bill
* @date 2020年8月28日
* @version V1.0
 */
@Data
public class PolymerizationTask {
	private String id;
	
	private String processorId;
	
	private String cronExpression;
	
	private String scheduleJobId;
	
	private String customerId;
}
