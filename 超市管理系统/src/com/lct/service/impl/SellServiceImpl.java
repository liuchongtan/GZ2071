package com.lct.service.impl;

import java.sql.Date;
import java.util.List;

import com.lct.dao.ISellDao;
import com.lct.dao.impl.SellDaoImpl;
import com.lct.domain.Sell;
import com.lct.service.ISellService;

public class SellServiceImpl implements ISellService {
	ISellDao isd = new SellDaoImpl();

	@Override
	public Double findallmoney() {

		return isd.findallmoney();
	}

	@Override
	public int save(Sell sell) {

		return isd.save(sell);
	}

	@Override
	public Double findallvipmoney() {
		// TODO Auto-generated method stub
		return isd.findallvipmoney();
	}

	@Override
	public Double findtodaynotvip(Date date) {

		return isd.findtodaynotvip(date);
	}

	@Override
	public Double findtodayvip(Date date) {

		return isd.findtodayvip(date);
	}

	@Override
	public List<Sell> findtodaysell(Date date) {

		return isd.findtodaysell(date);
	}

	@Override
	public List<Sell> findthisyear(Date date) {
		// TODO Auto-generated method stub
		return isd.findthisyear(date);
	}

	@Override
	public List<Sell> findthismonth(String month) {
		// TODO Auto-generated method stub
		return isd.findthismonth(month);
	}

}
