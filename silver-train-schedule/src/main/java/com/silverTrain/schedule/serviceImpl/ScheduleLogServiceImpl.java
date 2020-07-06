package com.silverTrain.schedule.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silverTrain.common.generic.GenericMapper;
import com.silverTrain.common.generic.GenericServiceImpl;
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
public class ScheduleLogServiceImpl extends GenericServiceImpl<ScheduleLog> implements ScheduleLogService{

	@Autowired
	private ScheduleLogMapper scheduleLogMapper;
	@Override
	protected GenericMapper<ScheduleLog> getGenericMapper() {
		return this.scheduleLogMapper;
	}
	
}
