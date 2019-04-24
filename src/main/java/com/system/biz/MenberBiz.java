package com.system.biz;

import java.util.List;

import com.system.domain.Menber;

public interface MenberBiz {
	//增加会员**
	public String addMenber(Menber m);
	//修改会员信息(挂失)/////////////////////////////////////////////////
	public String updatemenber(String mname, long phonenumber);
	//修改会员信息(充值)**
		public String updatemenber(long mbphone,double balance);
		//根据电话号码查找会员信息**
		public Menber selectmenberByphone(long phone);
		//根据电话号码删除会员信息**
		public String deleteMenberByphone(long phone);
		//会员解冻**
		public String unfreezemenber(long phone);
		//查询所有会员**
		public List<Menber> selectAllMenber();
		
}
