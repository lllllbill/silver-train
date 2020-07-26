package com.silverTrain.spider.core;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
public class DoubleQueue {
	private BlockingQueue<Request> quicklyQueue ;
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
