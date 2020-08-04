package com.silverTrain.spider.pageProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.silverTrain.schedule.entity.PageProcessorConfig;
import com.silverTrain.schedule.mapper.PageProcessorConfigMapper;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
/**
 * 
* @Title: PageProcessorSelector.java
* @Package com.silverTrain.spider.core
* @Description: pageProcessor选择器
* @author Bill
* @date 2020年7月26日
* @version V1.0
 */
@Slf4j
@Component
public class PageProcessorSelector implements PageProcessor{
	
	@Autowired
	private PageProcessorConfigMapper pageProcessorConfigMapper;
	
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);
    
	private List<PageProcessorConfig> pageProcessorConfig;
	
	private Map<String,PageProcessor> pageProcessorMap;
	
	public PageProcessorSelector(){
		init();
	}
	
	@Override
	public void process(Page page) {
		
	}

	@Override
	public Site getSite() {
		return this.site;
	}
	
	private Boolean init(){
		QueryWrapper<PageProcessorConfig> wrapper = new QueryWrapper<PageProcessorConfig>();
		wrapper.eq("status", "1");
		pageProcessorConfig = pageProcessorConfigMapper.selectList(wrapper);
		pageProcessorMap = new HashMap<String,PageProcessor>(20);
		return true;
	}
}
