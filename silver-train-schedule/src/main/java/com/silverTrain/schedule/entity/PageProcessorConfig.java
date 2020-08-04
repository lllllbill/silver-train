package com.silverTrain.schedule.entity;

import java.sql.Date;

import lombok.Data;

/**
 * 
* @Title: PageProcessConfig.java
* @Package com.silverTrain.schedule.entity
* @Description: 页面解析配置
* @author Bill
* @date 2020年7月23日
* @version V1.0
 */
@Data
public class PageProcessorConfig {
	/**
	 * id
	 */
	private String processorId;
	/**
	 *名字 
	 */
	private String processorName;
	
	private Date createTime;

	private Date updateTime;
	
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 任务执行时调用 类名
	 */
	private String className;
	/**
	 * 任务执行时调用哪个类的方法 包名+类名
	 */
	private String beanClass;
	/**
	 * 任务状态-是否在使用
	 */
	private String status;
	/**
	 * 正则匹配
	 */
	private String regex;
	/**
	 * 上层pageProcessor
	 */
	private String parentPageProcessorId;
	/**
	 * 下层pageProcessor
	 */
	private String childPageProcessorId;

}
