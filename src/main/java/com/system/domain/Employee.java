package com.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 111;
	private int utid;//雇员编号
	private String utname;//雇员名
	private String utsex;//雇员性别
	private int age;//雇员年龄
	private Date hiredate;//入职日期
	private double sal;//薪水
	private String job;//职位
	private String account;//员工账号
	private String password;//员工密码
	private long phonenumber;//员工联系方式
	private String idcard;//idcard
	public Employee() {
		super();
	}
	
	
	public Employee(int utid) {
		super();
		this.utid = utid;
	}


	public Employee(String utname, String utsex, int age, Date hiredate, double sal, String job, long phonenumber,
			String idcard) {
		super();
		this.utname = utname;
		this.utsex = utsex;
		this.age = age;
		this.hiredate = hiredate;
		this.sal = sal;
		this.job = job;
		this.phonenumber = phonenumber;
		this.idcard = idcard;
	}


	public Employee(String utname, String utsex, int age, Date hiredate, double sal, String job, String account,
			String password, long phonenumber, String idcard) {
		super();
		this.utname = utname;
		this.utsex = utsex;
		this.age = age;
		this.hiredate = hiredate;
		this.sal = sal;
		this.job = job;
		this.account = account;
		this.password = password;
		this.phonenumber = phonenumber;
		this.idcard = idcard;
	}


	public Employee(int utid, String utname, String utsex, int age, Date hiredate, double sal, String job,
			String account, String password, long phonenumber, String idcard) {
		super();
		this.utid = utid;
		this.utname = utname;
		this.utsex = utsex;
		this.age = age;
		this.hiredate = hiredate;
		this.sal = sal;
		this.job = job;
		this.account = account;
		this.password = password;
		this.phonenumber = phonenumber;
		this.idcard = idcard;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getUtid() {
		return utid;
	}
	public void setUtid(int utid) {
		this.utid = utid;
	}
	public String getUtname() {
		return utname;
	}
	public void setUtname(String utname) {
		this.utname = utname;
	}
	public String getUtsex() {
		return utsex;
	}
	public void setUtsex(String utsex) {
		this.utsex = utsex;
	}
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	@Override
	public String toString() {
		return "Employee [utid=" + utid + ", utname=" + utname + ", utsex=" + utsex + ", age=" + age + ", hiredate="
				+ hiredate + ", sal=" + sal + ", job=" + job + ", account=" + account + ", password=" + password
				+ ", phonenumber=" + phonenumber + ", idcard=" + idcard + "]";
	}
	public String show(){
		return utid+"\t"+utname+"\t"+utsex+"\t"+age+"\t"+hiredate+"\t"+sal+"\t"+job+"\t"+account+"\t"+password+"\t"+phonenumber+"\t"+idcard+"\t";
		
	}
	
	
	
}
