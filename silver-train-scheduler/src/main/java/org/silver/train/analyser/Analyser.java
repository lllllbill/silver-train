package org.silver.train.analyser;

import java.util.List;

import org.silver.train.job.Job;
import org.silver.train.task.Task;

public interface Analyser {
	public List<Job> analyserTask(Task task);
}
