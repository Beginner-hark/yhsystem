package com.system.biz.impl;

import com.system.biz.EmployeeBiz;
import com.system.dao.EmployeeDao;
import com.system.dao.MenberDao;
import com.system.dao.MenusDao;
import com.system.dao.TorderDao;
import com.system.dao.impl.EmployeeDaoImpl;
import com.system.domain.Employee;

public class EmployeeBizImpl implements EmployeeBiz{
	private EmployeeDao empDao;
	
	public EmployeeBizImpl() {
		super();
		this.empDao = new EmployeeDaoImpl();
	}

	@Override
	public Employee selectByAccount(String account) {
		Employee emp =this.empDao.selectByAccount( account);
		return emp;
	}

	@Override
	public String addemployee(Employee employee) {
		
		return this.empDao.addEmployee(employee)?"添加成功！":"添加失败！";
	}

	@Override
	public Employee selectByUtid(int utid) {
		return this.empDao.selectByUtid(utid);
	}

	@Override
	public String deleteById(int utid) {
		
		return this.empDao.deleteEmployee(utid)?"删除成功！":"删除失败！";
	}

	@Override
	public String updateemployee(int utid,double sal) {
	
		return this.empDao.updateEmployee(utid,sal)?"修改成功！":"修改失败";
	}

	
	
}
