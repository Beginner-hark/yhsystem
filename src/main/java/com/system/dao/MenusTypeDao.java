package com.system.dao;

import java.util.List;

import com.system.domain.MenusType;

public interface MenusTypeDao {
	//查询所有菜单类型表
	public List<MenusType> seletAllMenusType();
	//添加菜品类型
		public boolean addMenusType(MenusType mt);
		//删除菜品类型
		public boolean deleteMenusTypeBymtid(int mtid);
		//根据菜品类型id 修改菜品类型名
		public boolean updateMtname(int mtid,String mtname);
		//根据菜单类型id 查找菜单类型
		public MenusType selectByMtid(int mtid);

}
