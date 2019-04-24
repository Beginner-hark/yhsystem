package com.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Torder  implements Serializable{
	//属性
	private int tdid;		//编号
	private String tinum;	//订单编号
	private int utid;		//负责人编号
	private  Date td_date;	//订单日期
	
	
	//构造
	//无参
	public Torder() {
		super();
	}


	public Torder(int tdid, String tinum, int utid, Date td_date) {
		super();
		this.tdid = tdid;
		this.tinum = tinum;
		this.utid = utid;
		this.td_date = td_date;
	}


	public int getTdid() {
		return tdid;
	}


	public void setTdid(int tdid) {
		this.tdid = tdid;
	}


	public String getTinum() {
		return tinum;
	}


	public void setTinum(String tinum) {
		this.tinum = tinum;
	}


	public int getUtid() {
		return utid;
	}


	public void setUtid(int utid) {
		this.utid = utid;
	}


	public Date getTd_date() {
		return td_date;
	}


	public void setTd_date(Date td_date) {
		this.td_date = td_date;
	}


	@Override
	public String toString() {
		 return tdid+"\t"+tinum+"\t"+utid+"\t\t"+td_date;
	}


	
	
}
