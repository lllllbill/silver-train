package com.silverTrain.common.entity;

import lombok.Data;
import java.sql.Date;

/**
 * 
* @Title: PageResource.java
* @Package com.silverTrain.schedule.entity
* @Description: 页面资源存储
* @author Bill
* @date 2020年7月30日
* @version V1.0
 */
@Data
public class PageResource {
	private String id;
	
	private String processorId;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容地址
	 */
	private String url;
	/**
	 * 图片地址
	 */
	private String pictureUrl;
	/**
	 * 其他信息
	 */
	private String otherInfo;
	/**
	 * 创建时间
	 */
	private Date makeTime;
}
