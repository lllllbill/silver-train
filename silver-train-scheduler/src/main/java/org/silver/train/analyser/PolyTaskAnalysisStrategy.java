package org.silver.train.analyser;

import java.util.ArrayList;
import java.util.List;

import org.silver.train.job.Job;
import org.silver.train.schema.Target;
import org.silver.train.task.Task;
import org.silver.train.task.TaskType;
/*
 * 解析聚合任务
 */
public class PolyTaskAnalysisStrategy implements TaskAnalysisStrategy{

	private TaskType taskType =TaskType.POLYMERIZATIONTASK;
	
	@Override
	public TaskType taskType() {
		return this.taskType;
	}

	@Override
	public boolean supportType(TaskType taskType) {
		return this.taskType.equals(taskType);
	}

	@Override
	public List<Job> taskAnalySis(Task task) throws Exception {
		/*
		 * 新增任务-聚合任务
		 * 每工作日早上8点钟
		 * 聚合页面A与页面B的最新内容
		 * 
		 * 解析
		 * 
		 * 任务1 - 新增任务，发送任务
		 * 每工作日早上8点钟
		 * 发送聚合页面A和页面B的最新内容
		 * 发送目标-Bill
		 * 
		 * 任务2 - 新增任务，爬取任务
		 * 按照任务等级计算提前量-每天早上7点半
		 * 爬取页面A
		 * 
		 * 任务3 - 新增任务，爬取任务
		 * 按照任务等级计算提前量-每天早上7点半
		 * 爬取页面B
		 */
		List<Job> result = null;
		if(task.getTaskTarget().size()>0){
			result = new ArrayList<Job>(task.getTaskTarget().size()+1);
			int i =0;
			Class[] sendClassList = new Class[task.getTaskTarget().size()];
			for(Target target:task.getTaskTarget()){
				Job job = new Job();
				job.setJobType(Job.SPIDER);
				job.setOption(task.getTaskOption());
				job.setUser(task.getUser());
				Class[] spiderClassList = new Class[1];
				spiderClassList[0] = Class.forName(target.getSpiderClassName());
				sendClassList[i] = Class.forName(target.getSpiderClassName());
				i++;
				job.setTarget(spiderClassList);
				job.setTemporalFrequency(task.getTemporalFrequency());
				result.add(job);
			}
			Job job = new Job();
			job.setJobType(Job.SEND);
			job.setTarget(sendClassList);
			job.setOption(task.getTaskOption());
			job.setUser(task.getUser());
			job.setTemporalFrequency(task.getTemporalFrequency());
			result.add(job);
		}
		return result;
	}

}
