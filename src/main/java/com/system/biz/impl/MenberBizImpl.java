package com.system.biz.impl;

import java.util.List;

import com.system.biz.MenberBiz;
import com.system.dao.MenberDao;
import com.system.dao.impl.MenberDaoImpl;
import com.system.domain.Menber;

import oracle.net.aso.p;

public class MenberBizImpl implements MenberBiz {
	private MenberDao menDao;
	

	public MenberBizImpl() {
		super();
		this.menDao = new MenberDaoImpl();
	}


	@Override
	public String addMenber(Menber m) {
		return this.menDao.addMenber(m)?"操作成功！":"操作成功！";
	}


	@Override
	public String updatemenber(String mname, long phonenumber) {
		return this.menDao.updateMenber(mname,phonenumber)?"修改成功！":"修改失败！";
	}


	@Override
	public String updatemenber(long mbphone,double balance) {
		
		return this.menDao.updateMenber(mbphone,balance)?"充值成功！":"充值失败！";
	}


	@Override
	public Menber selectmenberByphone(long phone) {
		
		return this.menDao.selectmenberByphone(phone);
	}


	@Override
	public String deleteMenberByphone(long phone) {
		
		return this.menDao.deleteMenberByphone(phone)?"删除成功！":"删除失败！";
	}


	@Override
	public String unfreezemenber(long phone) {
		
		return this.menDao.unfreezemenber(phone)?"解冻成功！":"解冻失败！";
	}


	@Override
	public List<Menber> selectAllMenber() {
		
		return this.menDao.selectAllMenber();
	}

}
