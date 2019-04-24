package com.system.biz;

import com.system.domain.Employee;

public interface EmployeeBiz {
	//根据账户查询员工
	public Employee selectByAccount(String account);
	//manager添加员工new Employee(utname, utsex, age, hiredate, sal, job, phonenumber, idcard)*****
	public String addemployee(Employee employee);
	
	//根据员工编号查找员工**
	public Employee selectByUtid(int utid);
	//根据员工编号删除员工**
	public String deleteById(int utid);
	//根据utid 修改员工工资
	public String updateemployee(int utid,double sal);
	//查找所有员工
	


	
}
