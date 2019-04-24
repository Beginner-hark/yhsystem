package com.system.dao.impl;


import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.system.dao.MenusDao;
import com.system.domain.Menus;
import com.system.domain.TorderMenus;
import com.system.util.DBUtil;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;



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

	//删除菜品  根据id
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

	
	//查询所有菜品
	@Override
	public List<Menus> selectAllMenus() {
		// 实例化
		this.db = new DBUtil();
		// sql
		String sql = "select m.mid,m.mname,mt.mtname,m.mprice,m.bargain from menus m,menustype mt where m.mtid=mt.mtid";
		try {
			ResultSet rs = this.db.query(sql);
			List<Menus> list = new ArrayList<Menus>();
			while (rs.next()) {
				list.add(new Menus(rs.getInt("mid"), rs.getString("mname"), rs.getString("mtname"), rs.getDouble("mprice"),
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

	//根据菜名查询菜品
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

	//根据菜品id 设置为特价菜
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

	//查询菜品信息  根据id
	@Override
	public Menus selectById(int mid) {
		this.db = new DBUtil();
		String sql="select m.mid,m.mname,mt.mtname,m.mprice,m.bargain from menus m,menustype mt where mid ="+mid+" and m.mtid=mt.mtid";
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {// rs.getString("mtname"),
				Menus m = new Menus(rs.getInt("mid"), rs.getString("mname"), rs.getString("mtname"),
						rs.getDouble("mprice"), rs.getString("bargain"));
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

	@Override
	public boolean updateMenus() {

		return false;
	}

	//根据菜品类型查询某类型的所有菜品
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

	//根据首字母查询所有菜品
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

	//
	@Override
	public List<Menus> statisticsTotalSum() {
		this.db = new DBUtil();
		List<Menus> list = new ArrayList<>();
		String sql="select m.*,n.s from(select m.*,mt.mtname from menus m,menustype mt where m.mtid=mt.mtid) m,(select mname,sum(num)s from (select m.*,n.mtname from(select  m.*,tm.num from torder_menus tm,menus m where m.mid=tm.mid) m,menustype n where m.mtid=n.mtid) group by mname)n where m.mname=n.mname";
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

	//
	@Override
	public List<Menus> selectAllMenusByNo(int num) {
		this.db = new DBUtil();
		List<Menus> list = new ArrayList<>();
		String sql = "select * from (select m.*,n.s from(select m.*,mt.mtname from menus m,menustype mt where m.mtid=mt.mtid) m,(select mname,sum(num)s from (select m.*,n.mtname from(select  m.*,tm.num from torder_menus tm,menus m where m.mid=tm.mid) m,menustype n where m.mtid=n.mtid) group by mname)n where m.mname=n.mname) where rownum <="
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

	//打印菜单信息至Excel 表
	@Override
	public void printExc() {
		// TODO Auto-generated method stub
	
		
//		List<Menus> sam = this.selectAllMenus();
//		File file=new File("E://caidan.xls");
//		
//		if(!file.exists()){
//			try {
//				file.createNewFile();
//				for (Menus menus : sam) {
//					System.out.println(menus.getMid()+"="+menus.getMname()+"="+menus.getMtid()+"="+menus.getMprice()+"="+menus.getBargain());
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		wwb = Workbook.createWorkbook(file);
		
		WritableWorkbook wwb=null;
		WritableSheet ws=null;
		File file=new File("data/menus.xls");
		try {//创建.xls文件
			wwb = Workbook.createWorkbook(file);
			//创建工作表
			ws = wwb.createSheet("menus",0);
			//查询所有数据
			List<Menus> list = this.selectAllMenus();
			Label labelmid = new Label(0, 0, "编号");
			Label labelmname = new Label(1, 0, "菜名");
			Label labelmtname = new Label(2, 0, "菜类型");
			Label labelmprice = new Label(3, 0, "价格");
			Label labelbargain = new Label(4, 0, "特价菜(√/×)");
			ws.addCell(labelmid);
			ws.addCell(labelmname);
			ws.addCell(labelmtname);
			ws.addCell(labelmprice);
			ws.addCell(labelbargain);
			
			for (int i = 0; i < list.size(); i++) {
				jxl.write.Number Number = new jxl.write.Number(0, i+1, list.get(i).getMid());
				Label labelmname_i = new Label(1, i+1, list.get(i).getMname());
				Label labelmtname_i = new Label(2, i+1, list.get(i).getMtname());
				jxl.write.Number Number3= new jxl.write.Number(3, i+1, list.get(i).getMprice());
				Label labelbargain_i = new Label(4, i+1, list.get(i).getBargain());
				
				ws.addCell(Number);
				ws.addCell(labelmname_i);
				ws.addCell(labelmtname_i);
				ws.addCell(Number3);
				ws.addCell(labelbargain_i);
			}
			wwb.write();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(wwb!=null)wwb.close();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		
		
		
		
		
	}	
	
	
	
}
