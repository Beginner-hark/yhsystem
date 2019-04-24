package com.system.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

	@Override
	public double checkout(String uu, Employee emp) {
		
		this.db=new DBUtil();
		List<Menus>list=new ArrayList<>();
		double sum=0;
		System.out.println(uu);
		String sql="select m.*,tm.num from menus m,torder_menus tm where m.mid=tm.mid and tm.tinum='"+uu+"'";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				Menus m=new Menus(rs.getInt("mid"),rs.getString("mname"),rs.getDouble("mprice"),rs.getInt("num"));
				list.add(m);
				if("√".equals(rs.getString("bargain"))){
					sum=sum+rs.getDouble("mprice")*0.5*rs.getInt("num");
				}else{
					sum=sum+rs.getDouble("mprice")*rs.getInt("num");
				}
				
			}
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
	/*
	 * 将小票打印到本地
	 * */
	private void printstub(List<Menus> list,String uu) {
		
		System.out.println("          天津市亚惠餐饮餐饮有限公司");
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("单号："+uu);
		Date date =new Date();
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format = simp.format(date);
		System.out.println("销售日期:"+format);
		System.out.println("--------------------------");
		System.out.println("菜名  \t单价  \t数量");
		for (Menus menus : list) {
			if("√".equals(menus.getBargain())){
				menus.setMprice(menus.getMprice()*0.5);
			}
			menus.showmcheck();
		}
		System.out.println("--------------------------");
		System.out.println("数量："+list.size());
		System.out.println();
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

	@Override
	public Torder selectTorderbyCtimun(String ctinum) {
		this.db=new DBUtil();
		String sql="select * from torder where tinum='"+ctinum+"'";
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
