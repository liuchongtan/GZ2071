package com.lct.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.lct.dao.IClockDao;
import com.lct.dao.impl.ClockDaoImpl;
import com.lct.domain.Clock;

class ClockDaoImplTest {
     IClockDao ic=new ClockDaoImpl();
	@Test
	void testSave() {
		Date date1=new Date();
		Date date2=new Date();
		java.sql.Date date3=new java.sql.Date(date1.getTime());
		Clock clock=new Clock(17,"S0005",date1,date2,date3);
		ic.save(clock);
	}

	@Test
	void testDelete() {
		ic.delete(15);
	}

	@Test
	void testUpdate() {
		Date date1=new Date();
		Date date2=new Date();
		java.sql.Date date3=new java.sql.Date(date1.getTime());
		Clock clock=new Clock(17,"S0006",date1,date2,date3);
        ic.update(clock);
	}

	@Test
	void testGetBynum() {
		System.out.println(ic.getBynum(17));
	}

	@Test
	void testFindAllClock() {
		List<Clock> clocks=ic.findAllClock();
		clocks.forEach(clock->System.out.println(clock));
	}

}
