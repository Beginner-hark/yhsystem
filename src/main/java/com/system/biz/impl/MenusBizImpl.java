package com.system.biz.impl;

import java.util.List;
import java.util.Map;

import com.system.biz.MenusBiz;
import com.system.dao.MenusDao;
import com.system.dao.impl.MenusDaoImpl;
import com.system.domain.Menus;

public class MenusBizImpl implements MenusBiz {
	private MenusDao menusDao;

	public MenusBizImpl() {
		super();
		this.menusDao = new MenusDaoImpl();
	}

	@Override
	public List<Menus> selectAllMenus() {
		List<Menus> list = this.menusDao.selectAllMenus();
		return list;
	}

	
	@Override
	public Menus selectBymnane(String mname) {
		return this.menusDao.selectBymnane(mname);
	}

	@Override
	public String addMenus(Menus menus) {
		
		return this.menusDao.addMenus(menus)?"添加成功！":"添加失败！";
	}

	@Override
	public String deleteMenus(int mid) {

		return this.menusDao.deleteMenus(mid)?"删除成功！":"删除失败！";
	}

	@Override
	public Menus selectById(int mid) {
	
		return this.menusDao.selectById(mid);
	}

	@Override
	public String updateMenus(int mid) {
		
		return this.menusDao.updateMenus(mid)?"设置成功！":"设置失败！";
	}

	@Override
	public List<Menus> selectAllByMenusType() {
		
		return this.menusDao.selectAllByMenusType();
	}

	@Override
	public List<Menus> selectAllByInitial() {
		// TODO Auto-generated method stub
		return this.menusDao.selectAllByInitial();
	}

	@Override
	public List<Menus> statisticsTotalSum() {
		
		return this.menusDao.statisticsTotalSum();
	}

	@Override
	public List<Menus> selectAllMenusByNo(int num) {
		// TODO Auto-generated method stub
		return this.menusDao.selectAllMenusByNo(num);
	}

	

}
