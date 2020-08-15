package com.silverTrain.spider.pageProcessor;

import java.util.List;

public abstract class LinkedPageProcessor{
	protected boolean processorStatus =false;
	
	protected LinkedPageProcessor parentPageProcessor;
	
	protected LinkedPageProcessor childPageProcessor;
	
	protected List<String> taskList;
	/**
	 * 由该processor加载到队列的url数量，当清空时表示该任务爬取结束
	 */
	protected int urlNum;
	
	public boolean getStatus(){
		return this.processorStatus;
	}
	
}
