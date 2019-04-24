package com.system.control;

import java.util.List;
import java.util.Map;

import com.system.biz.EmployeeBiz;
import com.system.biz.MenberBiz;
import com.system.biz.MenusBiz;
import com.system.biz.MenusTypeBiz;
import com.system.biz.TorderBiz;
import com.system.biz.impl.EmployeeBizImpl;
import com.system.biz.impl.MenberBizImpl;
import com.system.biz.impl.MenusBizImpl;
import com.system.biz.impl.MenusTypeBizImpl;
import com.system.biz.impl.TorderBizImpl;
import com.system.domain.Employee;
import com.system.domain.Menber;
import com.system.domain.Menus;
import com.system.domain.MenusType;
import com.system.domain.Torder;

public class totalServiceImpl implements totalService{
	private EmployeeBiz empBiz;
	private MenberBiz menbBiz;
	private MenusBiz menusBiz;
	private TorderBiz torBiz;
	private MenusTypeBiz mentBiz;
	public totalServiceImpl() {
		super();
		this.empBiz = new EmployeeBizImpl();
		this.menbBiz = new MenberBizImpl();
		this.menusBiz = new MenusBizImpl();
		this.torBiz = new TorderBizImpl();
		this.mentBiz = new MenusTypeBizImpl();
	}


	@Override//根据账户查询员工
	public Employee selectByAccount(String account) {
		Employee emp=this.empBiz.selectByAccount(account);
		return emp;
	}

	@Override
	public List<Menus> selectAllMenus() {
		List<Menus> list=this.menusBiz.selectAllMenus();
		return list;
	}

	@Override
	public boolean addToTorderMenus(Map map,String str) {
		return   this.torBiz.addToTorderMenus(map,str);
		
	}

	@Override
	public Menus selectBymname(String mname) {
		
		return this.menusBiz.selectBymnane(mname);
	}

	@Override
	public List<Menus> selectAllTorderMenus() {
		
		return this.torBiz.selectAllTorderMenus();
	}

	@Override
	public double checkout(String uu, Employee emp) {
		
		return this.torBiz.checkout(uu,emp);
	}

	@Override
	public String joinmenber(Menber m) {
		String s = this.menbBiz.addMenber(m);
		return s;
	}

	@Override
	public String loss(String mname, long phonenumber) {
		
		return this.menbBiz.updatemenber(mname,phonenumber);
	}

	@Override
	public String recharge(long mbphone,double balance) {
		
		return this.menbBiz.updatemenber(mbphone,balance);
	}

	@Override
	public String addemployee(Employee employee) {
		
		return this.empBiz.addemployee(employee);
	}

	@Override
	public Employee selectByUtid(int utid) {
	
		return 	this.empBiz.selectByUtid(utid);
	}

	@Override
	public String deleteById(int utid) {
		
		return this.empBiz.deleteById(utid);
	}

	@Override
	public String updateemployee(int utid,double sal) {
		
		return this.empBiz.updateemployee(utid,sal);
	}

	@Override
	public List<Torder> selectAllTorder() {
		
		return this.torBiz.selectAllTorder();
	}

	@Override
	public List<Torder> selectTorderbyUtid(int utid) {
		return this.torBiz.selectTorderByUtid(utid);
	}

	@Override
	public Torder selectTorderbyCtimun(String ctinum) {
		return this.torBiz.selectTorderbyCtimun(ctinum);
		
	}

	@Override
	public Menber selectmenberByphone(long phone) {
		
		return this.menbBiz.selectmenberByphone(phone);
	}

	@Override
	public String deleteMenberByphone(long phone) {
		
		return this.menbBiz.deleteMenberByphone( phone);
	}

	@Override
	public String unfreezemenber(long phone) {
		
		return this.menbBiz.unfreezemenber(phone);
	}

	@Override
	public List<Menber> selectAllMenber() {
		
		return this.menbBiz.selectAllMenber();
	}

	@Override
	public List<MenusType> seletAllMenusType() {
		
		return this.mentBiz.seletAllMenusType();
	}

	@Override
	public String addMenus(Menus menus) {
		return this.menusBiz.addMenus(menus);
	}

	@Override
	public String deleteMenus(int mid) {
		return this.menusBiz.deleteMenus(mid);
	}

	@Override
	public Menus selectById(int mid) {
		
		return this.menusBiz.selectById(mid);
	}

	@Override
	public String updateMenus(int mid) {
		return this.menusBiz.updateMenus(mid);
	}

	@Override
	public List<Menus> selectAllByMenusType() {
		return this.menusBiz.selectAllByMenusType();
	}

	@Override
	public List<Menus> selectAllByInitial() {
		// TODO Auto-generated method stub
		return this.menusBiz.selectAllByInitial();
	}

	@Override
	public List<Menus> statisticsTotalSum() {
		
		return this.menusBiz.statisticsTotalSum();
	}

	@Override
	public List<Menus> selectAllMenusByNo(int num) {
		
		return this.menusBiz.selectAllMenusByNo(num);
	}


	@Override
	public String addMenusType(MenusType mt) {
		
		return this.mentBiz.addMenusType(mt);
	}


	@Override
	public String deleteMenustypeByMtid(int mtid) {
		// TODO Auto-generated method stub
		return this.mentBiz.deleteMenustypeByMtid(mtid);
	}


	@Override
	public String updateMtname(int mtid, String mtname) {
		
		return this.mentBiz.updateMtname(mtid, mtname);
	}


	@Override
	public MenusType selectByMtid(int mtid) {
		
		return this.mentBiz.selectByMtid(mtid);
	}

	
}
