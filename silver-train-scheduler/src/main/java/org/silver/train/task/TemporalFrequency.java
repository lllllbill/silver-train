package org.silver.train.task;
/*
 * 时间表达类
 */
public class TemporalFrequency {
	//模仿的是quartZ的时间表达方式
	private String temporalFrequency;
	
	public TemporalFrequency(String temporalFrequency){
		this.temporalFrequency = temporalFrequency;
	}
	
	public String getTemporalFrequency(){
		return this.temporalFrequency;
	}
	
	@Override
	public String toString(){
		return null;
	}
}
