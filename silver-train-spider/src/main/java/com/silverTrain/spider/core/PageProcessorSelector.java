package com.silverTrain.spider.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

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
public class PageProcessorSelector implements PageProcessor{
	
	@Autowired
	private PageProcessorConfigMapper pageProcessorConfigMapper;
	
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);
    
	private Map<String,PageProcessor> pageProcessorMap;
	
	public PageProcessorSelector(){
		init();
	}
	
	@Override
	public void process(Page page) {
		String url = page.getUrl().toString();
		for(Entry<String, PageProcessor> entry:pageProcessorMap.entrySet()){
			String pattern = entry.getKey();
			boolean isMatch = Pattern.matches(pattern, url);
			if(isMatch){
				PageProcessor processor = entry.getValue();
				processor.process(page);
			}else{
				continue;
			}
		}
	}

	@Override
	public Site getSite() {
		return this.site;
	}
	
	private Boolean init(){
		QueryWrapper<PageProcessorConfig> wrapper = new QueryWrapper<PageProcessorConfig>();
		wrapper.eq("status", "1");
		List<PageProcessorConfig> processorList = pageProcessorConfigMapper.selectList(wrapper);
		pageProcessorMap = new HashMap<String,PageProcessor>(processorList.size());
		for(PageProcessorConfig processor:processorList){
			String beanClass = processor.getBeanClass();
			try {
				Class processorClass = Class.forName(beanClass);
				try {
					PageProcessor page  = (PageProcessor)processorClass.newInstance();
					pageProcessorMap.put(processor.getRegex(), page);
				} catch (InstantiationException | IllegalAccessException e) {
					log.debug(beanClass+" instance fail;");
					e.printStackTrace();
					return false;
				}
			} catch (ClassNotFoundException e) {
				log.debug(beanClass+" class not found;");
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
