package com.myspring.minseon.startup.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("startuppagevo")
public class StartuppageVO {
	private String m_name;
	private Date e_date;
	private int e_status;
	
	private String manuname;
	private Date reqprod;
	private int prodstatus;
	
	private String expname;
	private Date reqdate;
	private int status;
	
	public String getExpname() {
		return expname;
	}
	public void setExpname(String expname) {
		this.expname = expname;
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
	public String getManuname() {
		return manuname;
	}
	public void setManuname(String manuname) {
		this.manuname = manuname;
	}
	public Date getReqprod() {
		return reqprod;
	}
	public void setReqprod(Date reqprod) {
		this.reqprod = reqprod;
	}
	public int getProdstatus() {
		return prodstatus;
	}
	public void setProdstatus(int prodstatus) {
		this.prodstatus = prodstatus;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public Date getE_date() {
		return e_date;
	}
	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}
	public int getE_status() {
		return e_status;
	}
	public void setE_status(int e_status) {
		this.e_status = e_status;
	}
	
	
}
