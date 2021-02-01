package com.lct.dao;

import java.util.List;

import com.lct.domain.Clock;
import com.lct.domain.ViewClock;

public interface IViewclockDao {
	// 根据日期返回考勤表
	public List<ViewClock> getByDate(java.sql.Date date);

	// 查询全部考勤表
	public List<ViewClock> findAllClock();
}
