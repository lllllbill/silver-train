package com.silverTrain.common.generic;

/**
 * 
* @Title: GenericMapper.java
* @Package com.silverTrain.common.generic
* @Description: Mapper基础类
* @author Bill
* @date 2020年7月6日
* @version V1.0
 */
public interface GenericMapper<T> {
	int insert(T record);
}
