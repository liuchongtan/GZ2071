package com.lct.dao;

import java.util.List;

import com.lct.domain.Good;
import com.lct.domain.Sell;

public interface ISellDao {
// 查询总营业额
	public Double findallmoney();

//收银添加方法
	public int save(Sell sell);

	// 查询总营业额
	public Double findallvipmoney();

	// 查询今日非会员销售额
	public Double findtodaynotvip(java.sql.Date date);

	// 查询今日会员销售额
	public Double findtodayvip(java.sql.Date date);

	// 得到今天的全部订单
	public List<Sell> findtodaysell(java.sql.Date date);
	
	//得到今年的所有订单
	public List<Sell> findthisyear(java.sql.Date date);
	//得到这个月的所有订单
	public List<Sell> findthismonth(String month);
}
