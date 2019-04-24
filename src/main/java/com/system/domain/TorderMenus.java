package com.system.domain;

public class TorderMenus {
private long tinum;//订单编号
private int mid;//菜编号
private int num;//数量

public TorderMenus() {
	super();
}

public TorderMenus(long tinum, int mid, int num) {
	super();
	this.tinum = tinum;
	this.mid = mid;
	this.num = num;
}

public long getTinum() {
	return tinum;
}

public void setTinum(long tinum) {
	this.tinum = tinum;
}

public int getMid() {
	return mid;
}

public void setMid(int mid) {
	this.mid = mid;
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

@Override
public String toString() {
	return "TorderMenus [tinum=" + tinum + ", mid=" + mid + ", num=" + num + "]";
}

public String show(){
	return tinum+"\t"+mid+"\t"+num;
}

}
