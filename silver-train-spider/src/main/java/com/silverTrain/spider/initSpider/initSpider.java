package com.silverTrain.spider.initSpider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.silverTrain.spider.core.DoubleQueueSchedule;
import com.silverTrain.spider.pageProcessor.PageProcessorSelector;

import us.codecraft.webmagic.Spider;

@Configuration
public class initSpider {
	
	@Bean
	public Spider getSpider(DoubleQueueSchedule scheduler,PageProcessorSelector selector){
		return new Spider(selector).setScheduler(scheduler).thread(5);
	}
}
