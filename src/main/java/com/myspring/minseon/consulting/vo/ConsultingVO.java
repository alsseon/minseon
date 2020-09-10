package com.myspring.minseon.consulting.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("consultingvo")
public class ConsultingVO {
	private String name;
	private Date reqdate;
	private int status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getReqdate() {
		return reqdate;
	}
	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
