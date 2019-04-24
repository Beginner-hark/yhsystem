package com.system.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.system.dao.EmployeeDao;
import com.system.domain.Employee;
import com.system.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private DBUtil db;

	public EmployeeDaoImpl() {
		super();
		this.db = db;
	}

	
	//添加员工
	@Override//new Employee(utname, utsex, age, hiredate, sal, job, phonenumber, idcard)
	public boolean addEmployee(Employee e) {
		// TODO Auto-generated method stub
				//实例化dbutil 对象
						this.db=new DBUtil();
						//创建sql 语句
						String sql="insert into user_table values(?,?,?,?,?,?,?,?,?,?,?)";
						try {
							Timestamp timestamp = new Timestamp(e.getHiredate().getTime());
							int i=this.db.update(sql,e.getUtid(),e.getUtname(),e.getUtsex(),e.getAge(),timestamp,e.getSal(),e.getJob(),e.getAccount(),e.getPassword(),e.getPhonenumber(),e.getIdcard());
							return i>0;
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							return false;
						}finally{
							this.db.closed();
						}

		
	}

	
	//根据员工编号删除员工
	@Override
	public boolean deleteEmployee(int utid) {

		this.db=new DBUtil();
		//创建sql语句
		String sql="delete from user_table where utid="+utid;
		try {
			int i=this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}

	}

	
//根据员工编号查询员工
	@Override
	public Employee selectByUtid(int utid) {
		this.db=new DBUtil();
		//创建sql 语句
		String sql="select * from user_table where utid="+utid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				Employee emp=new Employee();
				emp.setUtid(rs.getInt("utid"));
				emp.setUtname(rs.getString("utname"));
				emp.setUtsex(rs.getString("utsex"));
				emp.setAge(rs.getInt("age"));
				//获取日期
//				String str = rs.getString("hiredate");
//				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//				emp.setHiredate(sdf.parse(str));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setJob(rs.getString("job"));
				emp.setAccount(rs.getString("account"));
				emp.setPassword(rs.getString("password"));
				emp.setPhonenumber(rs.getLong("phonenumber"));
				emp.setIdcard(rs.getString("idcard"));
				return emp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.db.closed();
		}
		return null;

	}

	//根据员工编号修改员工工资
	@Override
	public boolean updateEmployee(int utid,double sal) {
		Employee emp=this.selectByUtid(utid);
		double GZ=sal+emp.getSal();
		this.db=new DBUtil();
		String sql="update user_table set sal="+GZ+"where utid="+utid;
		try {
			int i=this.db.update(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}

	}

	// 根据账号查找员工
	@Override
	public Employee selectByAccount(String account) {
		
		// 实例化dbutil 对象
		this.db = new DBUtil();
		// 创建sql 语句
		String sql = "select * from user_table where account=" + account;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				Employee emp = new Employee();
				emp.setUtid(rs.getInt("utid"));
				emp.setUtname(rs.getString("utname"));
				emp.setUtsex(rs.getString("utsex"));
				emp.setAge(rs.getInt("age"));
				// 获取日期
				// String str = rs.getString("hiredate");
				// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				// emp.setHiredate(sdf.parse(str));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setJob(rs.getString("job"));
				emp.setAccount(rs.getString("account"));
				emp.setPassword(rs.getString("password"));
				emp.setPhonenumber(rs.getLong("phonenumber"));
				emp.setIdcard(rs.getString("idcard"));
				return emp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.db.closed();
		}
		return null;
	}
/**
 *  
 *  查找所有员工
 *  
 *  
 */@Override
	public List<Employee> selectAllEmployee() {
		// TODO Auto-generated method stub
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from user_table";
		try {
			ResultSet rs= this.db.query(sql);
			List<Employee> list =new ArrayList<Employee>();
			while(rs.next()){
				//Date d=rs.getDate("hiredate");
//				//获取日期
				//String str = rs.getString("hiredate");
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				//Date parse = sdf.parse(str);
				//Date d =new Date(System.currentTimeMillis());
				list.add(new Employee(rs.getInt("utid"),rs.getString("utname"),rs.getString("utsex"),rs.getInt("age"), rs.getDate("hiredate"),rs.getDouble("sal"),rs.getString("job"),rs.getString("account"),rs.getString("password"),rs.getLong("phonenumber"),rs.getString("idcard")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.db.closed();
		}

	}

}
