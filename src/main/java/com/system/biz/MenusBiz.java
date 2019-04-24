package com.system.biz;

import java.util.List;
import java.util.Map;

import com.system.domain.Menus;

public interface MenusBiz {
//查询菜单所有信息*
	public List<Menus> selectAllMenus();
	
	//根据菜名查询菜**
	public Menus selectBymnane(String mname);
	//添加菜单信息***
	public String addMenus(Menus menus);
//根据菜id删除菜品**
	public String deleteMenus(int mid);
//根据菜id查询菜(包括类型和数量，三表连查)***
	public Menus selectById(int mid);
//设置特价菜**
	public String updateMenus(int mid);
//根据类型查找查找所有菜**
	public List<Menus> selectAllByMenusType();
//根据首字母排序查找所有菜**
	public List<Menus> selectAllByInitial();
//统计每种菜的当月销量***
	public List<Menus> statisticsTotalSum();
//统计销售量前num名
	public List<Menus> selectAllMenusByNo(int num);
	

}
