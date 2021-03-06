package com.silverTrain.spider.pageProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.silverTrain.common.entity.PageProcessorTable;
import com.silverTrain.common.unit.SpringUtils;
import com.silverTrain.schedule.mapper.PageProcessorTableMapper;

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
	private PageProcessorTableMapper pageProcessorTableMapper;
	
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
	/**
	 * 
	* @Title: init
	* @Description: 初始化pageProcessorMap
	* @param @return    参数
	* @return Boolean    返回类型
	* @throws
	 */
	private Boolean init(){
		QueryWrapper<PageProcessorTable> wrapper = new QueryWrapper<PageProcessorTable>();
		wrapper.eq("status", "1");
		List<PageProcessorTable> processorTable = pageProcessorTableMapper.selectList(wrapper);
		this.pageProcessorMap = new HashMap<String,PageProcessor>(processorTable.size());
		for(PageProcessorTable entry:processorTable){
			PageProcessor processor = SpringUtils.getBean(entry.getClassName());
			pageProcessorMap.put(entry.getRegex(), processor);
		}
		log.info("init PagePrcessorSelector");
		return true;
	}
}
