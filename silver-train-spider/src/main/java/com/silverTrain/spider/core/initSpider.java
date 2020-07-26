package com.silverTrain.spider.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import us.codecraft.webmagic.Spider;

@Configuration
public class initSpider {
	
	@Bean
	public DoubleQueue getQueue(){
		return new DoubleQueue();
	}
	
	@Bean
	public PageProcessorSelector getPageProcessorSelector(){
		return new PageProcessorSelector();
	}
	
	@Bean
	public Spider getSpider(DoubleQueueSchedule scheduler,PageProcessorSelector selector){
		return new Spider(selector).setScheduler(scheduler).thread(5);
	}
}
