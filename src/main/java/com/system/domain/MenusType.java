package com.system.domain;

public class MenusType {
private int mtid;
private String mtname;
public MenusType() {
	super();
}
public MenusType(int mtid, String mtname) {
	super();
	this.mtid = mtid;
	this.mtname = mtname;
}
public int getMtid() {
	return mtid;
}
public void setMtid(int mtid) {
	this.mtid = mtid;
}
public String getMtname() {
	return mtname;
}
public void setMtname(String mtname) {
	this.mtname = mtname;
}
@Override
public String toString() {
	return "MenusType [mtid=" + mtid + ", mtname=" + mtname + "]";
}
public String show(){
	return mtid+"\t"+mtname;
}

}
