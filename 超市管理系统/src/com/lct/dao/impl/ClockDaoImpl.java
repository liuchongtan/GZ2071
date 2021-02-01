package com.lct.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.lct.dao.IClockDao;
import com.lct.domain.Clock;
import com.lct.utils.JDBCUtil;

public class ClockDaoImpl implements IClockDao {

	@Override
	public int save(Clock clock) {
		String sql = "insert into clock_info values(?,?,?,?,?)";
		Object[] objects = { clock.getId(), clock.getEmpnum(), clock.getDatein(), clock.getDateoff(), clock.getDay() };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public int delete(int id) {
		String sql = "delete from clock_info where clock_id=?";
		Object[] objects = { id };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public int update(Clock clock) {
		String sql = "update clock_info set employee_no=?,clock_in_time=?,clock_off_time=?,clock_date=? where clock_id=?";
		Object[] objects = { clock.getEmpnum(), clock.getDatein(), clock.getDateoff(), clock.getDay(), clock.getId() };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public Clock getBynum(int id) {
		Clock clock = new Clock();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from clock_info where clock_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				clock.setId(rs.getInt("clock_id"));
				clock.setEmpnum(rs.getString(2));
				clock.setDatein(rs.getDate(3));
				clock.setDateoff(rs.getDate(4));
				clock.setDay(rs.getDate(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return clock;
	}

	@Override
	public List<Clock> findAllClock() {
		List<Clock> clocks = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from clock_info";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Clock clock = new Clock();
				clock.setId(rs.getInt("clock_id"));
				clock.setEmpnum(rs.getString(2));
				clock.setDatein(rs.getDate(3));
				clock.setDateoff(rs.getDate(4));
				clock.setDay(rs.getDate(5));
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
	public List<Clock> getByDate(Date date) {
		List<Clock> clocks = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from clock_info where clock_date=?";
			ps = conn.prepareStatement(sql);
			ps.setDate(1, date);
			rs = ps.executeQuery();
			while (rs.next()) {
				Clock clock = new Clock();
				clock.setId(rs.getInt("clock_id"));
				clock.setEmpnum(rs.getString(2));
				clock.setDatein(rs.getDate(3));
				clock.setDateoff(rs.getDate(4));
				clock.setDay(rs.getDate(5));
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
	public Clock getByempnum(String empnum, Date date) {
		Clock clock = new Clock();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from clock_info where employee_no=? and clock_date=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, empnum);
			ps.setDate(2, date);
			rs = ps.executeQuery();
			while (rs.next()) {
				clock.setId(rs.getInt("clock_id"));
				clock.setEmpnum(rs.getString(2));
				String datein = rs.getString(3);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date date2 = sdf.parse(datein);
				clock.setDatein(date2);
				clock.setDateoff(rs.getDate(4));
				clock.setDay(rs.getDate(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return clock;
	}

}
