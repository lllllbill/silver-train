package com.silverTrain.common.entity;

import lombok.Data;

/**
 * 
* @Title: Customer.java
* @Package com.silverTrain.common.entity
* @Description: 用户表
* @author Bill
* @date 2020年8月28日
* @version V1.0
 */
@Data
public class Customer {
	private String id;
	
	private String name;
	
	private String email;
	
	private String password;
}
