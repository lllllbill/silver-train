package com.silverTrain.common.entity;

import java.util.Date;

import lombok.Data;
/**
 * 
* @Title: ScheduleLog.java
* @Package com.silverTrain.schedule.entity
* @Description: 调度日志类
* @author Bill
* @date 2020年7月4日
* @version V1.0
 */
@Data
public class ScheduleLog {
	private String id;

    private String jobId;

    private String state;

    private Date createDate;

    private String reason;

    private static final long serialVersionUID = 1L;
}
