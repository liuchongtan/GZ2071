package com.lct.service;

import java.sql.Date;
import java.util.List;

import com.lct.domain.Clock;

public interface IClockService {
	//考勤表的增加方法
		public int save(Clock clock);
	//考勤表的删除方法
		public int delete(int id);
	//考勤表的修改方法
		public int update(Clock clock);
	//考勤表的根据id查询信息方法
		public Clock getBynum(int id);
	//查询全部考勤表
		public List<Clock> findAllClock();
		//根据日期返回考勤表
		public List<Clock> getByDate(java.sql.Date date);
		//根据打卡人编号和打卡日期返回打卡信息
		public Clock getByempnum(String empnum,Date date);
}
