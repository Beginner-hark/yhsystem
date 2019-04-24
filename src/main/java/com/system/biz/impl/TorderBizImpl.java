package com.system.biz.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.system.biz.TorderBiz;
import com.system.dao.TorderDao;
import com.system.dao.impl.TorderDaoImpl;
import com.system.domain.Employee;
import com.system.domain.Menus;
import com.system.domain.Torder;

public class TorderBizImpl implements TorderBiz {
	private TorderDao torderDao;

	public TorderBizImpl() {
		super();
		this.torderDao = new TorderDaoImpl();
	}

	@Override
	public boolean addToTorderMenus(Map map,String s) {
		
		return this.torderDao.addToTorderMenus(map,s);
	}

	@Override
	public List<Menus> selectAllTorderMenus() {
		
		return this.torderDao.selectAllTorderMenus();
	}

	@Override
	public double checkout(String uu, Employee emp) {
		
		return this.torderDao.checkout(uu,emp);
	}

	@Override
	public List<Torder> selectAllTorder() {
		
		return this.torderDao.selectAllTorder();
	}

	@Override
	public List<Torder> selectTorderByUtid(int utid) {
		return this.torderDao.selectTorderByUtid(utid);
	}

	@Override
	public Torder selectTorderbyCtimun(String ctinum) {
		return this.torderDao.selectTorderbyCtimun(ctinum);
	}
	
}
