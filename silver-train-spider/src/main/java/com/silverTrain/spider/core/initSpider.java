package com.silverTrain.spider.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class initSpider {
	
	@Bean
	public UrlQueue getQueue(){
		return new UrlQueue();
	}
}
