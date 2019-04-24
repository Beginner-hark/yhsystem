package com.system.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.system.dao.MenberDao;
import com.system.domain.Menber;
import com.system.util.DBUtil;

public class MenberDaoImpl implements MenberDao{
private DBUtil db;
	@Override
	public boolean addMenber(Menber mb) {
		this.db=new DBUtil();
		//sql  语句
		String sql ="insert into Menber values(seq_menber.nextval,?,?,?,?,?,?,?)";
		try {
			
			int i= this.db.update(sql,mb.getMbname(),mb.getMbsex(),mb.getMbage(),mb.getMbalance(),mb.getMbphone(),1,1);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}

	}

	
	@Override
	public List<Menber> selectAllMenber() {
		this.db=new DBUtil();
		//sql语句
		String sql="select * from menber";
		try {
			ResultSet rs=this.db.query(sql);
			List<Menber> list= new ArrayList<Menber>();
			while(rs.next()){
				list.add(new Menber(rs.getInt("mbid"),rs.getString("mbname"),rs.getString("mbsex"),rs.getInt("mbage"),rs.getDouble("mbalance"),rs.getLong("mbphone"),rs.getInt("mlid"),rs.getInt("mbstate")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.db.closed();
		}

	}
	@Override//根据姓名手机号，挂失会员卡
	public boolean updateMenber(String mname, long phonenumber) {
		Menber smbp = this.selectmenberByphone(phonenumber);
		this.db=new DBUtil();
		//调用查询方法获取指定对象的余额
		
		//sql
		String  sql="update menber set mbstate="+0+"where mbphone="+phonenumber;
		try {
			int i=this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}

	}

	@Override//会员充值
	public boolean updateMenber(long mbphone,double mbalance) {
		// TODO Auto-generated method stub
				//实例化dbutil对象
				Menber smbp = this.selectmenberByphone(mbphone);
				this.db=new DBUtil();
				//调用查询方法获取指定对象的余额
				
				double balance=mbalance+smbp.getMbalance();
				//sql
				String  sql="update menber set mbalance="+balance+"where mbphone="+mbphone;
				try {
					int i=this.db.update(sql);
					return i>0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					this.db.closed();
				}
				return false;
				

	}

	@Override
	public Menber selectmenberByphone(long phone) {
		this.db=new DBUtil();
		//sql
		String sql="select * from menber where mbphone="+phone;
		try {
			ResultSet rs= this.db.query(sql);
			if(rs.next()){
				Menber mb=new Menber();
				mb.setMbid(rs.getInt("mbid"));
				mb.setMbname(rs.getString("mbname"));
				mb.setMbsex(rs.getString("mbsex"));
				mb.setMbage(rs.getInt("mbage"));
				mb.setMbalance(rs.getDouble("mbalance"));
				mb.setMbphone(rs.getLong("mbphone"));
				mb.setMlid(rs.getInt("mlid"));
				mb.setMbstate(rs.getInt("mbstate"));

				return mb;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.db.closed();
		}
		return null;

	}

	@Override
	public boolean deleteMenberByphone(long phone) {
		this.db=new DBUtil();
		//sql语句
		String sql ="delete from menber where mbphone="+phone;
		try {
			int i=this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}

	}

	@Override
	public boolean unfreezemenber(long phone) {
		Menber smbp = this.selectmenberByphone(phone);
		this.db=new DBUtil();
		//调用查询方法获取指定对象的余额
		
		//sql
		String  sql="update menber set mbstate="+1+"where mbphone="+phone;
		try {
			int i=this.db.update(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}

	}

	/*
	 * 根据id删除会员
	 * */
	@Override
	public boolean deleteMenber(int mbid) {
		this.db=new DBUtil();
		//sql语句
		String sql ="delete from menber where mbid="+mbid;
		try {
			int i=this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}
		

	}

	

}
