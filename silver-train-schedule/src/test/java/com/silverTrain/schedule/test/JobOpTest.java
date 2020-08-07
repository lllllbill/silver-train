package com.silverTrain.schedule.test;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.silverTrain.schedule.SilverTrainApplication;
import com.silverTrain.spider.core.DoubleQueue;

import us.codecraft.webmagic.Request;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SilverTrainApplication.class)
public class JobOpTest {
	@Autowired
	private DoubleQueue doubleQueue;
	
	@Test
	public void addJob() throws SchedulerException{
		doubleQueue.putSlowly(new Request());
	}
}