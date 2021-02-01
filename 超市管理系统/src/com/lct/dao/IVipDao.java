package com.lct.dao;

import java.util.List;

import com.lct.domain.VIP;

public interface IVipDao {
//vip用户的增加方法
	public int save(VIP vip);

//vip用户的删除方法
	public int delete(String vnum);

//vip的修改方法
	public int update(VIP vip);

//vip的根据vnum查询信息方法
	public VIP getByVnum(String vnum);

//查询全部vip
	public List<VIP> findAllVip();

//会员登录方法
	public VIP viplogin(String loginname, String password);
}
