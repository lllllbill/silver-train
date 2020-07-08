package com.silverTrain.schedule.entity;

import java.util.Date;

import lombok.Data;
/**
 * 
* @Title: ScheduleJob.java
* @Package com.silverTrain.schedule.entity
* @Description: 任务类
* @author Bill
* @date 2020年7月4日
* @version V1.0
 */
@Data
public class ScheduleJob {
  public static final String STATUS_RUNNING = "1";  //正在运行

  public static final String STATUS_NOT_RUNNING = "0"; //已停止

  public static final String CONCURRENT_IS = "1";

  public static final String CONCURRENT_NOT = "0";

  private String jobId;

  private Date createTime;

  private Date updateTime;

  /**
   * 任务名称
   */
  private String jobName;

  /**
   * 任务分组
   */
  private String jobGroup;

  /**
   * 任务状态 是否启动任务
   */
  private String jobStatus;

  /**
   * cron表达式
   */
  private String cronExpression;

  /**
   * 描述
   */
  private String description;

  /**
   * 任务执行时调用哪个类的方法 包名+类名
   */
  private String beanClass;

  /**
   * 任务是否有状态
   */
  private String isConcurrent;

  /**
   * spring bean
   */
  private String springId;

  /**
   * 任务调用的方法名
   */
  private String methodName;

  private String jobData;

}
