package com.silverTrain.common.generic;
/**
 * 
* @Title: GenericServiceImpl.java
* @Package com.silverTrain.common.generic
* @Description: service实现基本类
* @author Bill
* @date 2020年7月5日
* @version V1.0
 */
public abstract class GenericServiceImpl<T extends Object> implements GenericService<T>{
	
	protected abstract GenericMapper<T> getGenericMapper();
	
	public int insert(T record){
		return this.getGenericMapper().insert(record);
	}
}
