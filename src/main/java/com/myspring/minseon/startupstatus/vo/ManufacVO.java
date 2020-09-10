package com.myspring.minseon.startupstatus.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("manufacvo")
public class ManufacVO {
	private String startup_name;
	private Date sttoes_date;
	private int sttoes_status;

	public String getStartup_name() {
		return startup_name;
	}
	public void setStartup_name(String startup_name) {
		this.startup_name = startup_name;
	}
	public Date getSttoes_date() {
		return sttoes_date;
	}
	public void setSttoes_date(Date sttoes_date) {
		this.sttoes_date = sttoes_date;
	}
	public int getSttoes_status() {
		return sttoes_status;
	}
	public void setSttoes_status(int sttoes_status) {
		this.sttoes_status = sttoes_status;
	}
	
	
}
