package com.silverTrain.schedule.test;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.silverTrain.schedule.SilverTrainApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SilverTrainApplication.class)
public class JobOpTest {
	@Autowired
	private Scheduler scheduler;
	
	@Test
	public void addJob() throws SchedulerException{
		 // define the job and tie it to our HelloJob class
		  JobDetail job = newJob(HelloJob.class)
		      .withIdentity("myJob", "group1")
		      .build();
		  System.out.println("hello JobDetail");
		  // Trigger the job to run now, and then every 40 seconds
		  Trigger trigger = newTrigger()
		      .withIdentity("myTrigger", "group1")
		      .startNow()
		      .withSchedule(simpleSchedule()
		          .withIntervalInSeconds(40)
		          .repeatForever())
		      .build();
		  System.out.println("hello Trigger");
		  // Tell quartz to schedule the job using our trigger
		  scheduler.scheduleJob(job, trigger);
	}
	
	class HelloJob implements Job{

		public void execute(JobExecutionContext context) throws JobExecutionException {
			System.out.println("hello quartZ");
		}
		
	}
}
