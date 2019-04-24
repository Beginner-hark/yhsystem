package com.system.domain;

import java.io.Serializable;

public class Menus implements Serializable{
private int mid;//菜编号
private String mname;//菜名
private int mtid;//菜品种类
private String mtname;//菜品种名称
private double mprice;//菜品单价
private String bargain;//是否特价菜
private int sum;//菜品销量
public Menus() {
	super();
}


public Menus(int mid, String mname, double mprice, String bargain) {
	super();
	this.mid = mid;
	this.mname = mname;
	this.mprice = mprice;
	this.bargain = bargain;
}


public Menus(int mid, String mname, double mprice, int sum) {
	super();
	this.mid = mid;
	this.mname = mname;
	this.mprice = mprice;
	this.sum = sum;
}


public Menus(int mid, String mname, int mtid, double mprice, String bargain) {
	super();
	this.mid = mid;
	this.mname = mname;
	this.mtid = mtid;
	this.mprice = mprice;
	this.bargain = bargain;
}

public Menus(int mid, String mname, String mtname, double mprice, String bargain) {
	super();
	this.mid = mid;
	this.mname = mname;
	this.mtname = mtname;
	this.mprice = mprice;
	this.bargain = bargain;
}


public Menus(int mid, String mname, String mtname, double mprice, String bargain, int sum) {
	super();
	this.mid = mid;
	this.mname = mname;
	this.mtname = mtname;
	this.mprice = mprice;
	this.bargain = bargain;
	this.sum = sum;
}


public Menus(int mid, String mname, int mtid, String mtname, double mprice, String bargain, int sum) {
	super();
	this.mid = mid;
	this.mname = mname;
	this.mtid = mtid;
	this.mtname = mtname;
	this.mprice = mprice;
	this.bargain = bargain;
	this.sum = sum;
}


public Menus(String mname, int mtid, double mprice) {
	super();
	this.mname = mname;
	this.mtid = mtid;
	this.mprice = mprice;
}


public Menus(int mid, String mname, int mtid, double mprice, String bargain, int sum) {
	super();
	this.mid = mid;
	this.mname = mname;
	this.mtid = mtid;
	this.mprice = mprice;
	this.bargain = bargain;
	this.sum = sum;
}


public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public int getMtid() {
	return mtid;
}
public void setMtid(int mtid) {
	this.mtid = mtid;
}

public double getMprice() {
	return mprice;
}


public void setMprice(double mprice) {
	this.mprice = mprice;
}


public String getMtname() {
	return mtname;
}


public void setMtname(String mtname) {
	this.mtname = mtname;
}


public String getBargain() {
	return bargain;
}
public void setBargain(String bargain) {
	this.bargain = bargain;
}

public int getSum() {
	return sum;
}
public void setSum(int sum) {
	this.sum = sum;
}
@Override
public String toString() {
	return "Menus [mid=" + mid + ", mname=" + mname + ", mtid=" + mtid + ", mtname=" + mtname + ", mprice=" + mprice
			+ ", bargain=" + bargain + ", sum=" + sum + "]";
}
public void show(){
	System.out.println(mid+"\t"+mname+"\t"+mtid+"\t"+mprice+"\t"+bargain);
}
public void showmyorder(Object o){
	System.out.println(mid+"\t"+mname+"\t"+mtid+"\t"+mprice+"\t"+bargain+"\t"+o);

}
public void showmcheck(){
	System.out.println(mname+"\t"+mprice+"\t"+sum);

}
}
