package com.silverTrain.schedule.init;

import org.quartz.SchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 
* @Title: initConfig.java
* @Package com.silverTrain.schedule.init
* @Description: 配置类
* @author Bill
* @date 2020年7月1日
* @version V1.0
 */

@Configuration
public class initConfig {

	@Bean(name="schedulerFactory")
    public  SchedulerFactory   initSchedulerFactoryBean() {
        return new org.quartz.impl.StdSchedulerFactory();
    }
}
