package org.silver.train.analyser;

import org.silver.train.task.Task;

public abstract class AbstractAnalyser implements Analyser{
	protected void onSuccess(Task task) {
	}

    protected void onError(Task task) {
    }
}
