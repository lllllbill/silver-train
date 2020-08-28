package com.silverTrain.schedule.util;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 
* @Title: UUIDUtil.java
* @Package com.silverTrain.schedule.unit
* @Description: 生成UUID
* @author Bill
* @date 2020年7月4日
* @version V1.0
 */
public class UUIDUtil {

    private UUIDUtil() {
    }

    public final static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取16位主键（日期+4位随机数）
    * @return
    * @author: jiawei
    * @2015年9月21日
     */
    public final static String getRequestId(){
        Date date =  new Date();
        String dateStr = DateFormatUtils.format(date, "yyMMddHHmmss");
        String s = RandomStringUtils.randomNumeric(4);  
        return dateStr+s;
    }
}
