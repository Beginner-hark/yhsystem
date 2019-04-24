package com.system.dao;

import java.util.List;
import java.util.Map;

import com.system.domain.Employee;
import com.system.domain.Menus;
import com.system.domain.Torder;



public interface TorderDao {
		// 增加订单
		public boolean addTorder(TorderDao t);

		// 删除订单
		public boolean deleteTorder(int tdid);

		// 查询所有订单
		public List<Torder> selectAllTorder();

		// 根据tdid查询
		public void selectByTid(int tdid);

		// 跟新订单信息
		public void updateTorder(int tdid);
		//将客户选择的菜加入列表 
		public boolean addToTorderMenus(Map map,String s);
//	查询所有点了的菜
		public List<Menus> selectAllTorderMenus();
//顾客结账
		public double checkout(String uu, Employee emp);
		//根据utid查询订单
		public List<Torder> selectTorderByUtid();
		//根据utid查询订单
		public List<Torder> selectTorderByUtid(int utid);
		//根据订单编号 查询订单
		public Torder selectTorderbyCtimun(String ctinum);
		
}
