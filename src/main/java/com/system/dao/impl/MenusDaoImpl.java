package com.system.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.system.dao.MenusDao;
import com.system.domain.Menber;
import com.system.domain.Menus;
import com.system.domain.TorderMenus;
import com.system.util.DBUtil;

public class MenusDaoImpl implements MenusDao {
	private DBUtil db;
	
	//添加菜品
	@Override
	public boolean addMenus(Menus menus) {
		this.db = new DBUtil();
		// insert into menus values(4,'水煮鱼',1,15,'×')
		String sql = "insert into menus values(seq_menus.nextval,?,?,?,?)";
		try {
			this.db.update(sql, menus.getMname(), menus.getMtid(), menus.getMprice(), "×");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		}
		return false;
	}

	@Override
	public boolean deleteMenus(int mid) {
		this.db = new DBUtil();
		// System.out.println("=========");
		String sql = "delete from menus where mid=?";
		try {
			// System.out.println(sql);
			int i = this.db.update(sql, mid);
			// System.out.println("=========");
			return i > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		}
		return false;
	}

	@Override
	public List<Menus> selectAllMenus() {
		// 实例化
		this.db = new DBUtil();
		// sql
		String sql = "select * from menus";
		try {
			ResultSet rs = this.db.query(sql);
			List<Menus> list = new ArrayList<Menus>();
			while (rs.next()) {
				list.add(new Menus(rs.getInt("mid"), rs.getString("mname"), rs.getInt("mtid"), rs.getDouble("mprice"),
						rs.getString("bargain")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.db.closed();
		}

	}

	@Override
	public Menus selectBymnane(String mname) {
		this.db = new DBUtil();
		String sql = "select * from menus where mname='" + mname + "'";
		try {
			// System.out.println("------------");
			ResultSet rs = this.db.query(sql);
			// System.out.println("===========");
			if (rs.next()) {
				Menus menus = new Menus(rs.getInt("mid"), rs.getString("mname"), rs.getDouble("mprice"),
						rs.getString("bargain"));
				return menus;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean updateMenus(int mid) {
		this.db = new DBUtil();
		String sql = "update menus set bargain='√' where mid=" + mid;
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		}
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMenus(String mname) {
		// TODO Auto-generated method stub

	}

	@Override
	public Menus selectById(int mid) {
		this.db = new DBUtil();
		String sql = "select m.*,tm.num from (select m.* ,mt.mtname from menus m,menustype mt where mid =" + mid
				+ " and m.mtid=mt.mtid)m,torder_menus tm";
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {// rs.getString("mtname"),
				Menus m = new Menus(rs.getInt("mid"), rs.getString("mname"), rs.getInt("mtid"), rs.getString("mtname"),
						rs.getDouble("mprice"), rs.getString("bargain"), rs.getInt("num"));
				return m;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		}
		return null;
	}

	@Override // 设置特价菜
	public boolean updateMenus() {

		return false;
	}

	@Override
	public List<Menus> selectAllByMenusType() {
		this.db = new DBUtil();
		List<Menus> list = new ArrayList<>();
		String sql = "select m.*,mt.mtname from menus m,menustype mt where m.mtid(+)=mt.mtid";
		try {
			ResultSet rs = this.db.query(sql);
			while (rs.next()) {
				Menus menus = new Menus(rs.getInt("mid"), rs.getString("mname"), rs.getString("mtname"),
						rs.getDouble("mprice"), rs.getString("bargain"));
				list.add(menus);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		}
		return null;
	}

	@Override
	public List<Menus> selectAllByInitial() {
		this.db = new DBUtil();
		List<Menus> list = new ArrayList<>();
		String sql = "select * from (select m.*,mt.mtname from menus m,menustype mt where m.mtid(+)=mt.mtid) order by mname";
		try {
			ResultSet rs = this.db.query(sql);
			while (rs.next()) {
				Menus menus = new Menus(rs.getInt("mid"), rs.getString("mname"), rs.getString("mtname"),
						rs.getDouble("mprice"), rs.getString("bargain"));
				list.add(menus);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		}
		return null;
	}

	@Override
	public List<Menus> statisticsTotalSum() {
		this.db = new DBUtil();
		List<Menus> list = new ArrayList<>();
		String sql = "select m.*,n.s from(select m.*,mt.mtname from menus m,menustype mt where m.mtid=mt.mtid) m,(select mname,sum(tmnum)s from (select m.*,n.mtname from(select  m.*,tm.tmnum from torder_menus tm,menus m where m.mid=tm.mid) m,menustype n where m.mtid=n.mtid) group by mname)n where m.mname=n.mname";
		try {
			ResultSet rs = this.db.query(sql);
			while (rs.next()) {
				Menus m = new Menus(rs.getInt("mid"), rs.getString("mname"), rs.getInt("mtid"), rs.getString("mtname"),
						rs.getDouble("mprice"), rs.getString("bargain"), rs.getInt("s"));
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		}
		return null;
	}

	@Override
	public List<Menus> selectAllMenusByNo(int num) {
		this.db = new DBUtil();
		List<Menus> list = new ArrayList<>();
		String sql = "select * from (select m.*,n.s from(select m.*,mt.mtname from menus m,menustype mt where m.mtid=mt.mtid) m,(select mname,sum(tmnum)s from (select m.*,n.mtname from(select  m.*,tm.tmnum from torder_menus tm,menus m where m.mid=tm.mid) m,menustype n where m.mtid=n.mtid) group by mname)n where m.mname=n.mname) where rownum <="
				+ num;
		ResultSet rs;
		try {
			rs = this.db.query(sql);
			while (rs.next()) {
				Menus m = new Menus(rs.getInt("mid"), rs.getString("mname"), rs.getInt("mtid"), rs.getString("mtname"),
						rs.getDouble("mprice"), rs.getString("bargain"), rs.getInt("s"));
			list.add(m);
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
}
