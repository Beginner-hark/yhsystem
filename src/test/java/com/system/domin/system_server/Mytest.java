package com.system.domin.system_server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;

import com.system.biz.impl.MenberBizImpl;
import com.system.control.totalService;
import com.system.control.totalServiceImpl;
import com.system.dao.EmployeeDao;
import com.system.dao.MenusDao;
import com.system.dao.MenusTypeDao;
import com.system.dao.TorderDao;
import com.system.dao.impl.EmployeeDaoImpl;
import com.system.dao.impl.MenusDaoImpl;
import com.system.dao.impl.MenusTypeDaoImpl;
import com.system.dao.impl.TorderDaoImpl;
import com.system.domain.Employee;
import com.system.domain.Menber;
import com.system.domain.Menus;
import com.system.domain.MenusType;
import com.system.util.DBUtil;

import oracle.sql.DATE;

public class Mytest {
/*	@Test
private void show() {
DBUtil db=new DBUtil();

}*/
	public static void main(String[] args) {
//		MenusDao m=new MenusDaoImpl();
//		TorderDaoImpl t=new TorderDaoImpl();
//		totalService ts=new totalServiceImpl();
//		MenberBizImpl mb=new MenberBizImpl();
		MenusTypeDao mtd=new MenusTypeDaoImpl();
		/*DBUtil db=new DBUtil()
		EmployeeDao dao=new EmployeeDaoImpl();
		Employee emp = dao.selectByAccount("333");
	System.out.println(emp);*/
	/*
	 * menustype测试
	 * MenusTypeDao mt=new MenusTypeDaoImpl();
	List<MenusType> list = mt.seletAllMenusType();
	System.out.println(list.size());
	for (MenusType menusType : list) {
		System.out.println(menusType);
	}
		MenusDao m=new MenusDaoImpl();
		List<Menus> list = m.selectAllMenus();
		for (Menus menus : list) {
			System.out.println(menus);
		}
		*/
//		System.out.println(m.selectBymnane("老虎菜"));
	
//		boolean ba = m.addMenus(new Menus("炸蘑菇",2,20));

//		boolean b = m.deleteMenus(10);
//		System.out.println(m.updateMenus(3));
//		Menus menusd = m.selectById(1);
//		System.out.println(menusd);
	/*List<Menus> list = m.selectAllMenusByNo(1);
	for (Menus menus : list) {
		System.out.println(menus);
	}*/
		/*UUID uuid=UUID.randomUUID();
		String ud=uuid.toString().replaceAll("-", "");
		System.out.println(ud);
		String string = ud.substring(0, 20);
		System.out.println(string);*/
		/*String s="ss1a31sd31313s";
		Map map=new HashMap<>();
		map.put(1, 2);
		map.put(2, 1);
		Set k = map.keySet();
		for (Object object : k) {
			System.out.println(object);
		}
		boolean b = t.addToTorderMenus(map, s);
		System.out.println(b);*/
		/*double d = t.checkout("ss1a31sd31313s");
		System.out.println(d);*/
		/*DATE date =new DATE();
		System.out.println(date);
		t.addtorder("13s13dsdsa551", new Employee(1));*/
//		List<Menus> list = m.selectAllMenus();
		/*List<Menus> list = ts.selectAllMenus();
		
		for (Menus menus : list) {
			System.out.println(menus);
		}Menus n = ts.selectById(1);
		System.out.println(n);*/
		//String z = mb.addMenber(new Menber("小dsa","男",15,155,17777777777l));
	//System.out.println(z);
		
		//System.out.println(mtd.addMenusType(new MenusType(5,"酒水")));
		
		
		//System.out.println(mtd.deleteMenusTypeBymtname("肉菜"));
		System.out.println(mtd.updateMtname(3, "汤类"));
		
	}
}
