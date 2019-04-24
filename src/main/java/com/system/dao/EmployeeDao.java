package com.system.dao;

import java.util.List;

import com.system.domain.Employee;

public interface EmployeeDao {
	// 增加员工new Employee(utname, utsex, age, hiredate, sal, job, phonenumber, idcard)
	public boolean addEmployee(Employee e);

	// 删除员工
	public boolean deleteEmployee(int utid);

	// 查询所有员工
	public List<Employee> selectAllEmployee();

	// 根据uid查询员工
	public Employee selectByUtid(int utid);

	// 根据员工Account查询员工
	public Employee selectByAccount(String account);

	// 跟新员工信息（修改工资）
	public boolean updateEmployee(int utid,double sal);

}
