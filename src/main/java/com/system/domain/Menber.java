package com.system.domain;

import java.io.Serializable;

public class Menber implements Serializable{
	private int mbid;      	 	//会员编号
	private String mbname;  	//会员名
	private String mbsex;  	//会员性别
	private int mbage;      	//会员年龄
	private double mbalance;	//会员余额
	private long mbphone;		//会员手机号
	private int mlid;			//会员等级编号
	private int mbstate;		//会员状态
	public Menber() {
		super();
	}
	public Menber(int mbid, String mbname, String mbsex, int mbage, double mbalance, long mbphone, int mlid,
			int mbstate) {
		super();
		this.mbid = mbid;
		this.mbname = mbname;
		this.mbsex = mbsex;
		this.mbage = mbage;
		this.mbalance = mbalance;
		this.mbphone = mbphone;
		this.mlid = mlid;
		this.mbstate = mbstate;
	}
	
	public Menber(String mbname, String mbsex, int mbage, double mbalance, long mbphone) {
		super();
		this.mbname = mbname;
		this.mbsex = mbsex;
		this.mbage = mbage;
		this.mbalance = mbalance;
		this.mbphone = mbphone;
	}
	public int getMbid() {
		return mbid;
	}
	public void setMbid(int mbid) {
		this.mbid = mbid;
	}
	public String getMbname() {
		return mbname;
	}
	public void setMbname(String mbname) {
		this.mbname = mbname;
	}
	public String getMbsex() {
		return mbsex;
	}
	public void setMbsex(String mbsex) {
		this.mbsex = mbsex;
	}
	public int getMbage() {
		return mbage;
	}
	public void setMbage(int mbage) {
		this.mbage = mbage;
	}
	public double getMbalance() {
		return mbalance;
	}
	public void setMbalance(double mbalance) {
		this.mbalance = mbalance;
	}
	public long getMbphone() {
		return mbphone;
	}
	public void setMbphone(long mbphone) {
		this.mbphone = mbphone;
	}
	public int getMlid() {
		return mlid;
	}
	public void setMlid(int mlid) {
		this.mlid = mlid;
	}
	public int getMbstate() {
		return mbstate;
	}
	public void setMbstate(int mbstate) {
		this.mbstate = mbstate;
	}
	@Override
	public String toString() {
		return "Menber [mbid=" + mbid + ", mbname=" + mbname + ", mbsex=" + mbsex + ", mbage=" + mbage + ", mbalance="
				+ mbalance + ", mbphone=" + mbphone + ", mlid=" + mlid + ", mbstate=" + mbstate + "]";
	}
	public String show(){
		return mbid+"\t"+mbname+"\t"+mbsex+"\t"+mbage+"\t"+mbalance+"\t"+mbphone+"\t"+mlid+"\t"+mbstate;
	} 

}
