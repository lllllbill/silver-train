package com.silverTrain.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silverTrain.schedule.entity.ScheduleLog;
import com.silverTrain.schedule.mapper.ScheduleLogMapper;
import com.silverTrain.schedule.service.ScheduleLogService;

import lombok.extern.slf4j.Slf4j;
/**
 * 
* @Title: ScheduleJobServiceImpl.java
* @Package com.silverTrain.schedule.serviceImpl
* @Description: ScheduleLogService实现类
* @author Bill
* @date 2020年7月5日
* @version V1.0
 */
@Slf4j
@Service
public class ScheduleLogServiceImpl implements ScheduleLogService{
	@Autowired
	private ScheduleLogMapper scheduleLogMapper;

	public int insert(ScheduleLog entity) {
		return scheduleLogMapper.insert(entity);
	}
	
}
