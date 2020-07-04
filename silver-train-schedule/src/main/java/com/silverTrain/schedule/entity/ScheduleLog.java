package com.silverTrain.schedule.entity;

import java.util.Date;
/**
 * 
* @Title: ScheduleLog.java
* @Package com.silverTrain.schedule.entity
* @Description: 调度日志类
* @author Bill
* @date 2020年7月4日
* @version V1.0
 */
public class ScheduleLog {
	private String id;

    private String jobId;

    private String state;

    private Date createDate;

    private String reason;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}
