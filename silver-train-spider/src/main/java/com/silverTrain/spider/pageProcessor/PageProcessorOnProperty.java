package com.silverTrain.spider.pageProcessor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
/**
 * 
* @Title: PageProcessorOnProperty.java
* @Package com.silverTrain.spider.pageProcessor
* @Description: 用于处理PageProcessor是否注入
* @author Bill
* @date 2020年8月4日
* @version V1.0
 */
public @interface PageProcessorOnProperty {
	String className();
}
