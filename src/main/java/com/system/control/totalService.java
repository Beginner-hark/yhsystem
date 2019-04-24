package com.system.control;

import java.util.List;
import java.util.Map;

import com.system.domain.Employee;
import com.system.domain.Menber;
import com.system.domain.Menus;
import com.system.domain.MenusType;
import com.system.domain.Torder;

public interface totalService {


	// 根据账户查询员工
	public Employee selectByAccount(String account);

	// 查询所有菜单中信息
	public List<Menus> selectAllMenus();

	// 将客户选择的菜加入列表 
	public boolean addToTorderMenus(Map map,String s);

	// 根据菜名查询menus中菜的信息
	public Menus selectBymname(String mname);

	// 查询所有torder信息包含num*********
	public List<Menus> selectAllTorderMenus();
	//消費者结账
		public double checkout(String uu, Employee emp);
		//办理会员卡
		public String joinmenber( Menber m);
		//waiter根据姓名和手机号挂失会员卡
		public String loss(String mname, long phonenumber);
		//waiter给会员充值
		public String recharge(long mbphone,double balance);
		//manager添加员工new Employee(utname, utsex, age, hiredate, sal, job, phonenumber, idcard)
		public String addemployee(Employee employee);
		//根据员工编号查找员工
		public Employee selectByUtid(int utid);
		//根据员工编号删除员工
		public String deleteById(int utid);
		//根据员工id修改员工工资
		public String updateemployee(int utid,double sal);
		//查询所有订单
		public List<Torder> selectAllTorder();
		//根据员工编号查询所有订单
		public List<Torder> selectTorderbyUtid(int utid);
		//根据订单编号 查询订单
		public Torder selectTorderbyCtimun(String ctinum);
		//根据手机号查询会员
		public Menber selectmenberByphone(long utid);
		//根据手机号删除会员
		public String deleteMenberByphone(long phone);
		//会员解冻
		public String unfreezemenber(long phone);
		//查询所有会员
		public List<Menber> selectAllMenber();
		//查询所有菜品种类
		public List<MenusType> seletAllMenusType();
		//添加菜品
		public String addMenus(Menus menus);
		//根据菜id删除菜
		public String deleteMenus(int mid);
		//根据mid查找菜
		public Menus selectById(int mid);
		//跟新菜的信息----设置特价菜
		public String updateMenus(int mid);
		//根据菜的类型查询所有菜
		public List<Menus> selectAllByMenusType();
		//根据首字母排序查询所有才
		public List<Menus> selectAllByInitial();
		//统计每种菜的当月销售量
		public List<Menus> statisticsTotalSum();
		//统计销售量前num名
		public List<Menus> selectAllMenusByNo(int num);
		//添加菜品类型
				public String addMenusType(MenusType mt);
				//删除菜品类型
				public String deleteMenustypeByMtid(int mtid);
				//根据菜品类型id 修改菜品类型名
				public String updateMtname(int mtid,String mtname);
				//根据菜单类型id 查找菜单类型
				public MenusType selectByMtid(int mtid);
}
