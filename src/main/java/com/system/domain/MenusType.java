package com.system.domain;

import java.io.Serializable;

public class MenusType implements Serializable{
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
	return mtid+"\t"+mtname;

}

}
