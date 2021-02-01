package com.lct.service.impl;

import java.sql.Date;
import java.util.List;

import com.lct.dao.IClockDao;
import com.lct.dao.impl.ClockDaoImpl;
import com.lct.domain.Clock;
import com.lct.service.IClockService;

public class ClockServiceImpl implements IClockService {
	IClockDao icd = new ClockDaoImpl();

	@Override
	public int save(Clock clock) {

		return icd.save(clock);
	}

	@Override
	public int delete(int id) {

		return icd.delete(id);
	}

	@Override
	public int update(Clock clock) {
		return icd.update(clock);
	}

	@Override
	public Clock getBynum(int id) {
		return icd.getBynum(id);
	}

	@Override
	public List<Clock> findAllClock() {

		return icd.findAllClock();
	}

	@Override
	public List<Clock> getByDate(Date date) {

		return icd.getByDate(date);
	}

	@Override
	public Clock getByempnum(String empnum, Date date) {

		return icd.getByempnum(empnum, date);
	}

}
