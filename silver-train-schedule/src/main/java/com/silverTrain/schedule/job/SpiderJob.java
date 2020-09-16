package com.silverTrain.schedule.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.silverTrain.common.entity.PageProcessorTable;
import com.silverTrain.common.entity.PageResource;
import com.silverTrain.common.entity.PolymerizationTask;
import com.silverTrain.common.unit.DateUtils;
import com.silverTrain.common.unit.SpringUtils;
import com.silverTrain.schedule.mapper.PageProcessorTableMapper;
import com.silverTrain.schedule.mapper.PageResourceMapper;
import com.silverTrain.schedule.mapper.PolymerizationTaskMapper;
import com.silverTrain.spider.core.DoubleQueue;
import com.silverTrain.spider.pageProcessor.LinkedPageProcessor;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Request;
/**
 * 
* @Title: SpiderJob.java
* @Package com.silverTrain.schedule.job
* @Description: quartz spider job
* @author Bill
* @date 2020年8月28日
* @version V1.0
 */
@Slf4j
public class SpiderJob implements Job{
	@Autowired
	private PolymerizationTaskMapper polymerizationMapper;
	@Autowired
	private PageResourceMapper pageResourceMapper;
	@Autowired
	private PageProcessorTableMapper pageProcessorTableMapper;
	@Autowired
	private DoubleQueue doubleQueue;
	
	private static int intervalTime = 1;
	
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		String scheduleJobId = dataMap.getString("scheduleJobId");
		//具有资源的task
		Set<String> haveResourceTaskList = new LinkedHashSet<String>();
		//没有资源的task
		Set<String> noResourceTaskList = new LinkedHashSet<String>();
		//processor对应的task
		Map<String,List<String>> processorWithTaskMap = new HashMap<String,List<String>>();
		//获取该时间下的所有任务
		QueryWrapper<PolymerizationTask> wrapper = new QueryWrapper<PolymerizationTask>();
		wrapper.eq("scheduleJobId",scheduleJobId);
		List<PolymerizationTask> polymerizationTaskList = polymerizationMapper.selectList(wrapper);
		QueryWrapper<PageResource> wrapper2 = new QueryWrapper<PageResource>();
		wrapper2.lt("makeDate", DateUtils.formatDate((DateUtils.nextHour(-intervalTime))));
		for(PolymerizationTask task:polymerizationTaskList){
			//资源创建时间小于当前时间减去配置时间为不满足
			wrapper2.eq("processorId",task.getProcessorId());
			//如果没有满足的资源，并启动任务
			if(pageResourceMapper.selectOne(wrapper2)==null){
				noResourceTaskList.add(task.getId());
				haveResourceTaskList.remove(task.getId());
				if(processorWithTaskMap.containsKey(task.getProcessorId())){
					processorWithTaskMap.get(task.getProcessorId()).add(task.getId());
				}else{
					List<String> taskIdList = new ArrayList<String>();
					taskIdList.add(task.getId());
					processorWithTaskMap.put(task.getProcessorId(),taskIdList );
				} 
			//如果有满足的资源，且全满足都通知发送任务
			}else{
				if(!noResourceTaskList.contains(task.getId())){
					haveResourceTaskList.add(task.getId());
				}
			}
		}
		LinkedPageProcessor processor = null;
		Request request = null;
		//启动对应的processor
		for(Entry<String, List<String>> entry:processorWithTaskMap.entrySet()){
			String processorId = entry.getKey();
			PageProcessorTable processorTable = pageProcessorTableMapper.selectById(processorId);
			processor = SpringUtils.getBean(processorTable.getClassName());
			processor.setTaskList(entry.getValue());
			processor.startProcessor();
			request = new Request();
			request.setUrl(processorTable.getUrl());
			doubleQueue.putSlowly(request);
		}
		//启动发送任务
		for(String str:haveResourceTaskList){
			
		}
	}

}
