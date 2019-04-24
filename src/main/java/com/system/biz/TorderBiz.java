package com.system.biz;

import java.util.List;
import java.util.Map;

import com.system.domain.Employee;
import com.system.domain.Menus;
import com.system.domain.Torder;

public interface TorderBiz {
	//将客户选择的菜加入列表 **
		public boolean addToTorderMenus(Map map,String s);
		//查询所有点了的菜品信息（待定）
		public List<Menus> selectAllTorderMenus();
		//消費者結賬
		public double checkout(String uu, Employee emp);
		//查询所有订单**
		public List<Torder> selectAllTorder();
		//根据utid查询订单**
		public List<Torder> selectTorderByUtid(int utid);
		//根据订单编号 查询订单**
		public Torder selectTorderbyCtimun(String ctinum);
}
