package com.system.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.system.dao.MenusTypeDao;
import com.system.domain.MenusType;
import com.system.util.DBUtil;

public class MenusTypeDaoImpl implements MenusTypeDao{
private DBUtil db;

	public MenusTypeDaoImpl() {
	super();
	this.db = db;
}

	@Override
	public List<MenusType> seletAllMenusType() {
		this.db=new DBUtil();
		List<MenusType> list=new ArrayList<>();
		String sql="select * from menustype";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				MenusType menustype=new MenusType();
				menustype.setMtid(rs.getInt("mtid"));
				menustype.setMtname(rs.getString("mtname"));
				list.add(menustype);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.db.closed();
		}
		return null;
	}
	/*//添加菜品类型
		public boolean addMenusType(MenusType mt);
		//删除菜品类型
		public boolean deleteMenusTypeBymtname(String mtname);
		//根据菜品类型id 修改菜品类型名
		public boolean updateMtname(int mtid,String mtname);*/
		//增加菜品类型
		@Override
		public boolean addMenusType(MenusType mt) {
			// TODO Auto-generated method stub
			this.db=new DBUtil();
			String sql="insert into menustype values(?,?)";
			try {
				this.db.query(sql,mt.getMtid(),mt.getMtname());
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				this.db.closed();
			}
			
		}
		
		//删除菜品类型

		@Override
		public boolean deleteMenusTypeBymtid(int mtid) {
			// TODO Auto-generated method stub
			this.db=new DBUtil();
			String sql="delete from menustype where mtid='"+mtid+"'";
			try {
				this.db.query(sql);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				this.db.closed();
			}
			
			
		}
		
		//根据菜品类型id 修改菜品类型名的方法

		@Override
		public boolean updateMtname(int mtid, String mtname) {
			// TODO Auto-generated method stub
			this.db=new DBUtil();
			String sql="update menustype set mtname='"+mtname+"'where mtid="+mtid;
			try {
				this.db.update(sql);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				this.db.closed();
			}
			
		}
		//根据菜单类型id 查找菜单类型的方法
		@Override
		public MenusType selectByMtid(int mtid) {
			// TODO Auto-generated method stub
			this.db  = new DBUtil();
			String sql="select * from menustype where mtid="+mtid;
			try {
				ResultSet rs=this.db.query(sql);
				if(rs.next()){
					MenusType mt=new MenusType();
					mt.setMtid(rs.getInt("mtid"));
					mt.setMtname(rs.getString("mtname"));
					return mt;
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
