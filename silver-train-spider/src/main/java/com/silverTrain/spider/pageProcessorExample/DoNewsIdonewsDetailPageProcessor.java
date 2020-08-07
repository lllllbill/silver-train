package com.silverTrain.spider.pageProcessorExample;

import com.silverTrain.spider.pageProcessor.LinkedPageProcessor;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Slf4j
public class DoNewsIdonewsDetailPageProcessor extends LinkedPageProcessor implements PageProcessor{
	
	@Override
	public void process(Page page) {
		
	}
	@Override
	public Site getSite() {
		return null;
	}
}
