package com.system.dao;

import java.util.List;
import java.util.Map;

import com.system.domain.Menber;
import com.system.domain.Menus;
import com.system.domain.TorderMenus;

public interface MenusDao {
	// 增加菜品
	public boolean addMenus(Menus menus);

	// 删除菜品
	public boolean deleteMenus(int utid);

// 查询所有菜品
	public List<Menus> selectAllMenus();

// 根据菜名查询菜
	public Menus selectBymnane(String mname);

	// 跟新菜品信息  mid
	public boolean updateMenus(int mid);

	// 跟新菜品信息 mnane
	public void updateMenus(String  mname);
	//根据菜id查询菜
	public Menus selectById(int mid);
	//设置特价菜
	public boolean updateMenus();
	//根据类型查找查早所有菜
	public List<Menus> selectAllByMenusType();
	//根据首字母排序查找所有菜
	public List<Menus> selectAllByInitial();
//统计没种菜的当月销售量（1菜mid  * 2.菜的mname * 3.菜的销售量）
	public List<Menus> statisticsTotalSum();
//统计销售量前num名
	public List<Menus> selectAllMenusByNo(int num);

	
}
