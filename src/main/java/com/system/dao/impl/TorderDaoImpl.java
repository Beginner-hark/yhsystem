package com.system.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.system.dao.TorderDao;
import com.system.domain.Employee;
import com.system.domain.Menus;
import com.system.domain.Torder;
import com.system.util.DBUtil;

import oracle.sql.DATE;
import oracle.sql.TIMESTAMP;

public class TorderDaoImpl implements TorderDao{
private DBUtil db;

	public TorderDaoImpl() {
	super();
	this.db = db;
}

	@Override
	public boolean addTorder(TorderDao t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTorder(int tdid) {
		// TODO Auto-generated method stub
		return false;
	}

	//查询所有订单
	@Override
	public List<Torder> selectAllTorder() {
		this.db=new DBUtil();
		String sql="select * from torder";
		try {
			ResultSet rs=this.db.query(sql);
			List<Torder> list=new ArrayList<Torder>();
			while(rs.next()){
				list.add(new Torder(rs.getInt("tdid"),rs.getString("tinum"),rs.getInt("utid"),rs.getDate("td_date")));
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

	@Override
	public void selectByTid(int tdid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTorder(int tdid) {
		// TODO Auto-generated method stub
		
	}

	//添加菜品到子菜单
	@Override
	public boolean addToTorderMenus(Map map,String s) {
		System.out.println(s);
		Set keySet = map.keySet();
		for (Object object : keySet) {
			System.out.println(object+"****"+map.get(object));
		}
		this.db=new DBUtil();
		Set k = map.keySet();
		System.out.println(map.size());
		int i = 0;
		for (Object o : k) {
			
			String sql="insert into torder_menus values(?,?,?)";
			try {
				i = this.db.update(sql,s,o,map.get(o));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.db.closed();
		return i>0;
		
		
	}

	@Override
	public List<Menus> selectAllTorderMenus() {
		// TODO Auto-generated method stub
		return null;
	}

	
	//结账
	@Override
	public double checkout(String uu, Employee emp) {
		
		this.db=new DBUtil();
		List<Menus>list=new ArrayList<>();
		double sum=0;
		String sql="select m.*,tm.num from menus m,torder_menus tm where m.mid=tm.mid";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				Menus m=new Menus(rs.getInt("mid"),rs.getString("mname"),rs.getDouble("mprice"),rs.getInt("num"));
				list.add(m);
				sum=sum+rs.getDouble("mprice")*rs.getInt("num");
			}
			/*System.out.println(list.size());
			for (Menus menus : list) {
				System.out.println(menus);
			}*/
			this.addtorder(uu, emp);
			return sum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.db.closed();
		}
		return 0;
	}
	
	
	 /*******
	  * 将订单信息存入torder
	  * ************/
	public void addtorder(String uu, Employee emp) {
		this.db=new DBUtil();
		String sql="insert into torder values(seq_torder.nextval,?,?,?)";
//		DATE date =new DATE();
		Date date =new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		try {
			int i = this.db.update(sql, uu,emp.getUtid(),timestamp);
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.db.closed();
		}
	}
	@Override
	public List<Torder> selectTorderByUtid() {
		// TODO Auto-generated method stub
		return null;
	}

	//查询某一负责人负责的所有订单
	@Override
	public List<Torder> selectTorderByUtid(int utid) {
		this.db=new DBUtil();
		String sql="select * from torder where utid="+utid;
		try {
			ResultSet rs = this.db.query(sql);
			List<Torder> list=new ArrayList<Torder>();
			while(rs.next()){
				list.add(new Torder(rs.getInt("tdid"),rs.getString("tinum"),rs.getInt("utid"),rs.getDate("td_date")));
				
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

	//根据订单编号查询订单
	@Override
	public Torder selectTorderbyCtimun(String ctinum) {
		this.db=new DBUtil();
		String sql="select * from torder where tinum="+ctinum;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				Torder t=new Torder();
				t.setTdid(rs.getInt("tdid"));
				t.setTinum(rs.getString("tinum"));
				t.setUtid(rs.getInt("utid"));
				t.setTd_date(rs.getDate("td_date"));
				return t;
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

	

}
