package com.lct.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lct.dao.IViewclockDao;
import com.lct.domain.Clock;
import com.lct.domain.ViewClock;
import com.lct.utils.JDBCUtil;

public class ViewclockDaoImpl implements IViewclockDao {

	@Override
	public List<ViewClock> getByDate(Date date) {
		List<ViewClock> clocks = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from check_info where work_date=?";
			ps = conn.prepareStatement(sql);
			ps.setDate(1, date);
			rs = ps.executeQuery();
			while (rs.next()) {
				ViewClock clock = new ViewClock();
				clock.setWorkdate(rs.getDate(1));
				clock.setEmpnumber(rs.getString(2));
				clock.setDatein(rs.getDate(3));
				clock.setDateoff(rs.getDate(4));
				clock.setChidao(rs.getString(5));
				clock.setZaotui(rs.getString(6));
				clocks.add(clock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return clocks;
	}

	@Override
	public List<ViewClock> findAllClock() {
		List<ViewClock> clocks = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from check_info";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ViewClock clock = new ViewClock();
				clock.setWorkdate(rs.getDate(1));
				clock.setEmpnumber(rs.getString(2));
				clock.setDatein(rs.getDate(3));
				clock.setDateoff(rs.getDate(4));
				clock.setChidao(rs.getString(5));
				clock.setZaotui(rs.getString(6));
				clocks.add(clock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return clocks;
	}

}
