package com.lct.service.impl;

import java.util.List;

import com.lct.dao.IGoodDao;
import com.lct.dao.impl.GoodDaoImpl;
import com.lct.domain.Good;
import com.lct.service.IGoodService;

public class GoodServiceImpl implements IGoodService {

	IGoodDao igd = new GoodDaoImpl();

	@Override
	public int save(Good good) {

		return igd.save(good);
	}

	@Override
	public int delete(String number) {
		// TODO Auto-generated method stub
		return igd.delete(number);
	}

	@Override
	public int update(Good good) {
		// TODO Auto-generated method stub
		return igd.update(good);
	}

	@Override
	public Good getBynum(String number) {
		// TODO Auto-generated method stub
		return igd.getBynum(number);
	}

	@Override
	public List<Good> findAllVip() {
		// TODO Auto-generated method stub
		return igd.findAllVip();
	}

	@Override
	public List<Good> listlessGoods() {
		// TODO Auto-generated method stub
		return igd.listlessGoods();
	}

}
