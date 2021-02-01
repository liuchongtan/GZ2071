package com.lct.dao;

import java.util.List;

import com.lct.domain.Good;
import com.lct.domain.VIP;

public interface IGoodDao {
	// 商品的增加方法
	public int save(Good good);

	// 商品的删除方法
	public int delete(String number);

	// 商品的修改方法
	public int update(Good good);

	// 商品的根据number查询信息方法
	public Good getBynum(String number);

	// 查询全部商品
	public List<Good> findAllVip();

	// 查询库存少于100的商品
	public List<Good> listlessGoods();
}
