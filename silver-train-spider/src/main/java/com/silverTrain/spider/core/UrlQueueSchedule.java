package com.silverTrain.spider.core;

import org.springframework.beans.factory.annotation.Autowired;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.DuplicateRemovedScheduler;
import us.codecraft.webmagic.scheduler.MonitorableScheduler;

public class UrlQueueSchedule extends DuplicateRemovedScheduler implements MonitorableScheduler {

	@Autowired
	private UrlQueue urlQueue;
	
 	@Override
    public void pushWhenNoDuplicate(Request request, Task task) {
        this.urlQueue.putSlowly(request);
    }
 	
 	@Override
    public Request poll(Task task) {
		return this.urlQueue.poll();
    }
 	
 	@Override
    public int getLeftRequestsCount(Task task) {
        return urlQueue.size();
    }
 	
 	@Override
    public int getTotalRequestsCount(Task task) {
        return getDuplicateRemover().getTotalRequestsCount(task);
    }

}
