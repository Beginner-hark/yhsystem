package com.system.dao;

import java.util.List;

import com.system.domain.Menber;

public interface MenberDao {
// 增加会员
		public boolean addMenber(Menber mb);

		// 删除会员
		public boolean deleteMenber(int mbid);

// 查询所有会员
		public List<Menber> selectAllMenber();

		// 跟新会员信息（挂失）
		public boolean updateMenber(String mname, long phonenumber);
		//会员充值
		public boolean updateMenber(long mbphone,double balance);
//根据电话查询会员
		public Menber selectmenberByphone(long phone);
//根据电话删除会员
		public boolean deleteMenberByphone(long phone);
//会员解冻
		public boolean unfreezemenber(long phone);

	

}
