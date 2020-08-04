package com.silverTrain.spider.core;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Request;

/**
 * 
* @Title: UrlQueue.java
* @Package com.silverTrain.spider.core
* @Description: 储存待爬取URL
* @author Bill
* @date 2020年7月20日
* @version V1.0
 */
@Component
public class DoubleQueue {
	/**
	 * 用于处理紧急url
	 */
	private BlockingQueue<Request> quicklyQueue ;
	/**
	 * 用于处理非紧急url
	 */
	private BlockingQueue<Request> slowlyQueue;
	
	public DoubleQueue(){
		this.quicklyQueue = new LinkedBlockingQueue<Request>(1000);
		this.slowlyQueue = new LinkedBlockingQueue<Request>(1000);
	}
	
	public boolean putSlowly(Request request){
		return this.slowlyQueue.offer(request);
	}
	
	public boolean putQuickly(Request request){
		return this.quicklyQueue.offer(request);
	}
	
	public Request poll(){
		Request request;
		if((request=this.quicklyQueue.poll())==null){
			try {
				request = this.slowlyQueue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return request;
	}
	
	public int size(){
		return this.slowlyQueue.size()+this.quicklyQueue.size();
	}
}
