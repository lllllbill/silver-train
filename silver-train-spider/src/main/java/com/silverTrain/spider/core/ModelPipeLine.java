package com.silverTrain.spider.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.silverTrain.schedule.entity.PageResource;
import com.silverTrain.schedule.mapper.PageResourceMapper;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * 
* @Title: ModelPipeLine.java
* @Package com.silverTrain.spider.core
* @Description: 页面内容进行数据库存储。
* @author Bill
* @date 2020年7月30日
* @version V1.0
 */
@Slf4j
public class ModelPipeLine implements Pipeline{
	@Autowired
	private PageResourceMapper pageResourceMapper;

	@Override
	public void process(ResultItems resultItems, Task task) {
		PageResource res = resultItems.get("Res");
		pageResourceMapper.insert(res);
		log.info(resultItems.toString()+"insert pageResource");;
	}

}
