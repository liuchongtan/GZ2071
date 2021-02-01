package com.lct.service.impl;

import java.sql.Date;
import java.util.List;

import com.lct.dao.IViewclockDao;
import com.lct.dao.impl.ViewclockDaoImpl;
import com.lct.domain.ViewClock;
import com.lct.service.IViewclockService;

public class ViewclockServiceImpl implements IViewclockService {
	IViewclockDao ivd = new ViewclockDaoImpl();

	@Override
	public List<ViewClock> getByDate(Date date) {

		return ivd.getByDate(date);
	}

	@Override
	public List<ViewClock> findAllClock() {

		return ivd.findAllClock();
	}

}
