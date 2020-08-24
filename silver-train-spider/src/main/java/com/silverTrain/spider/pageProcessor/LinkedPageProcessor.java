package com.silverTrain.spider.pageProcessor;

import java.util.LinkedList;
import java.util.List;

import us.codecraft.webmagic.processor.PageProcessor;
/**
 * 
* @Title: LinkedPageProcessor.java
* @Package com.silverTrain.spider.pageProcessor
* @Description: LinkedPageProcessor抽象类
* @author Bill
* @date 2020年8月21日
* @version V1.0
 */
public abstract class LinkedPageProcessor implements PageProcessor{
	protected boolean processorStatus =false;
	
	protected LinkedPageProcessor parentPageProcessor;
	
	protected LinkedPageProcessor childPageProcessor;
	
	protected List<String> taskList;
	/**
	 * 由该processor加载到队列的url数量，当清空时表示该任务爬取结束
	 */
	protected volatile int urlNum;

	protected boolean masterFlag = false;
	
	protected boolean leafFlag = false;
	
	public void setProcessorStatus(boolean processorStatus) {
		this.processorStatus = processorStatus;
	}

	public void setParentPageProcessor(LinkedPageProcessor parentPageProcessor) {
		this.parentPageProcessor = parentPageProcessor;
	}

	public void setChildPageProcessor(LinkedPageProcessor childPageProcessor) {
		this.childPageProcessor = childPageProcessor;
	}

	public void setTaskList(List<String> taskList) {
		this.taskList = taskList;
	}

	public void setUrlNum(int urlNum) {
		this.urlNum = urlNum;
	}

	public void setMasterFlag(boolean masterFlag) {
		this.masterFlag = masterFlag;
	}

	public void setLeafFlag(boolean leafFlag) {
		this.leafFlag = leafFlag;
	}

	//多线程下的processor状态
	public boolean getStatus(){
		boolean childProcessorStatus = this.childPageProcessor.getStatus();
		if(childProcessorStatus){
			return true;
		}else{
			if(urlNum==0&&!this.processorStatus){
				return false;
			}else{
				return true;
			}
		}
	}
	
	private void on(){
		this.processorStatus = true;
	}
	
	//启动按钮
	protected synchronized boolean startProcessor(){
		if(processorStatus){
			return false;
		}else{
			on();
			taskList.clear();
			this.urlNum = 0;
			if(leafFlag||this.childPageProcessor.startProcessor()){
				return true;
			}else{
				return false;
			}
		}
	}
	//强制关闭按钮。(要不要只有master节点给操作？)
	public synchronized void ForcedShutdown(){
		
	}
	
	public void off(){
		if(this.urlNum==0){
			if(!masterFlag){
				this.processorStatus = false;
				this.parentPageProcessor.off();
			}else{
				//该任务结束，通知task
			}
		}
	}
	
	private synchronized void addUrlNum(int newUrlNum){
		if(!processorStatus){
			on();
		}
		this.urlNum +=newUrlNum;
	}
	
	private synchronized void subUrlNum(){
		this.urlNum -=1;
		if(this.urlNum==0&&(this.leafFlag||!childPageProcessor.getStatus())){
			off();
		}
	}
	
	//每次该processor执行时，减去当前processor任务数量，给子processor加上任务数量
	public void excute(int newUrlNum){
		if(!leafFlag){
			this.childPageProcessor.addUrlNum(newUrlNum);
		}
		subUrlNum();
	}
}
