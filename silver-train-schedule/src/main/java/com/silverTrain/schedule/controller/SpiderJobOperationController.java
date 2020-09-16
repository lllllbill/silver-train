package com.silverTrain.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silverTrain.common.unit.Result;
import com.silverTrain.schedule.service.SpiderTaskOperatorService;

import lombok.extern.slf4j.Slf4j;
/**
 * 
* @Title: SpiderJobOperationController.java
* @Package com.silverTrain.schedule.controller
* @Description: 用户任务操作
* @author Bill
* @date 2020年9月16日
* @version V1.0
 */
@Controller
@Slf4j
@RequestMapping(value = "/index")
public class SpiderJobOperationController {
	
	@Autowired
	private SpiderTaskOperatorService spiderTaskOperatorService;
}
