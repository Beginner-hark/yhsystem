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
	//根据账号查询员工
	@Override
	public Employee selectByAccount(String account) {
		Employee emp =this.empDao.selectByAccount( account);
		return emp;
	}
	
	//添加员工
	@Override
	public String addemployee(Employee employee) {
		
		return this.empDao.addEmployee(employee)?"添加成功！":"添加失败！";
	}

		//根据utid 查询员工
	@Override
	public Employee selectByUtid(int utid) {
		return this.empDao.selectByUtid(utid);
	}

	//根据utid 删除员工
	@Override
	public String deleteById(int utid) {
		
		return this.empDao.deleteEmployee(utid)?"删除成功！":"删除失败！";
	}
	
	//根据utid 修改对应员工的工资信息
	@Override
	public String updateemployee(int utid,double sal) {
	
		return this.empDao.updateEmployee(utid,sal)?"修改成功！":"修改失败";
	}

	
	
}
