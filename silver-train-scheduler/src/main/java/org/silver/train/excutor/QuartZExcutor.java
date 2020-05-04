package org.silver.train.excutor;

import java.util.List;

import org.silver.train.task.Task;
import org.silver.train.task.TemporalFrequency;

public class QuartZExcutor extends AbstractExcutor{


	@Override
	public String changeTemporalFrequency(TemporalFrequency temporalFrequency) {
		return temporalFrequency.getTemporalFrequency();
	}

	@Override
	public void excutorJobs(List<Task> tasksToBePerformed) {
		
	}
	
	private void deletedJob(Task task){
		
	}
	
	private void addJob(Task task){
		
	}

}
