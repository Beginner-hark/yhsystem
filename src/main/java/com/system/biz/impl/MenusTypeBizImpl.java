package com.system.biz.impl;

import java.util.List;

import com.system.biz.MenusTypeBiz;
import com.system.dao.MenusTypeDao;
import com.system.dao.impl.MenusTypeDaoImpl;
import com.system.domain.MenusType;

public class MenusTypeBizImpl implements MenusTypeBiz {
private MenusTypeDao mentDao;

	public MenusTypeBizImpl() {
	super();
	this.mentDao = new MenusTypeDaoImpl();
}

		//查询所有菜品类型
	@Override
	public List<MenusType> seletAllMenusType() {
		return this.mentDao.seletAllMenusType();
	}

	//添加菜品类型
	@Override
	public String addMenusType(MenusType mt) {
		// TODO Auto-generated method stub
		return this.mentDao.addMenusType(mt)?"添加成功":"添加失败";
	}

	//删除菜品类型
	@Override
	public String deleteMenustypeByMtname(String mtname) {
		// TODO Auto-generated method stub
		return this.mentDao.deleteMenusTypeBymtname(mtname)?"删除成功":"删除失败";
	}
	//根据菜品类型id修改类型名

	@Override
	public String updateMtname(int mtid, String mtname) {
		// TODO Auto-generated method stub
		return this.mentDao.updateMtname(mtid, mtname)?"修改成功":"修改失败";
	}

	//根据菜单类型id 查找菜单类型
	@Override
	public MenusType selectByMtid(int mtid) {
		// TODO Auto-generated method stub
		return this.mentDao.selectByMtid(mtid);
	
	}
	
	
	



}
