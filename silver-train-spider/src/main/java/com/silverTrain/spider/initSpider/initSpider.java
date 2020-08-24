package com.silverTrain.spider.initSpider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.silverTrain.spider.core.DoubleQueueSchedule;
import com.silverTrain.spider.pageProcessor.LinkedPageProcessor;
import com.silverTrain.spider.pageProcessor.PageProcessorSelector;
import com.silverTrain.spider.pageProcessorExample.DoNewsIdonewsDetailPageProcessor;
import com.silverTrain.spider.pageProcessorExample.DoNewsIdonewsPageProcessor;

import us.codecraft.webmagic.Spider;

@Configuration
public class initSpider {
	
	@Bean
	public Spider Spider(DoubleQueueSchedule scheduler,PageProcessorSelector selector){
		return new Spider(selector).setScheduler(scheduler).thread(5);
	}	
	
	@Bean("doNewsPageProcessor")
	public LinkedPageProcessor doNewsPageProcessor(LinkedPageProcessor doNewsDetailPageProcessor){
		DoNewsIdonewsPageProcessor bean = new DoNewsIdonewsPageProcessor();
		bean.setChildPageProcessor(doNewsDetailPageProcessor);
		return bean;
	}
	
	@Bean("doNewsDetailPageProcessor")
	public LinkedPageProcessor doNewsIdonewsPageProcessor(LinkedPageProcessor doNewsPageProcessor){
		DoNewsIdonewsDetailPageProcessor bean = new DoNewsIdonewsDetailPageProcessor();
		bean.setParentPageProcessor(doNewsPageProcessor);
		return bean;
	}
}
