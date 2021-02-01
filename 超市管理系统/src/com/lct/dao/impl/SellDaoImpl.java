package com.lct.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.lct.dao.ISellDao;
import com.lct.domain.Sell;
import com.lct.domain.VIP;
import com.lct.utils.JDBCUtil;

public class SellDaoImpl implements ISellDao {

	@Override
	public Double findallmoney() {
		Double allmoney = 0.0D;
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "SELECT SUM(g.c_price * s.s_quantity)  FROM goods g,sell_info s WHERE s.`s_c_number`=g.`c_number`and s.s_vip_number is null";
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				allmoney = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, statement, rs);
		}
		return allmoney;
	}

	@Override
	public int save(Sell sell) {
		String sql = "insert into sell_info values(?,?,?,?,?)";
		Object[] objects = { sell.getGoodnumber(), sell.getQuantity(), sell.getSelltime(), sell.getEnumber(),
				sell.getVipnumber() };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public Double findallvipmoney() {
		Double allmoney = 0.0D;
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "SELECT SUM(g.vip_price * s.s_quantity),s.s_time  FROM goods g,sell_info s WHERE s.`s_c_number`=g.`c_number`and s.s_vip_number is not null";
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				allmoney = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, statement, rs);
		}
		return allmoney;
	}

	@Override
	public Double findtodaynotvip(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Double money = 0.0d;
		Date date1 = new Date(new java.util.Date().getTime());
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "SELECT SUM(g.c_price * s.s_quantity),s.s_time  FROM goods g,sell_info s WHERE s.`s_c_number`=g.`c_number` and s.s_vip_number is  null";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Date date2 = rs.getDate(2);
				String utildate = sdf.format(date2);
				if (date1.toString().equals(utildate)) {
					money = money + rs.getDouble(1);
				}
//				if(rs.getDate(2)==date1) {
//					money+=rs.getDouble(1);
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return money;
	}

	@Override
	public Double findtodayvip(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Double money = 0.0d;
		Date date1 = new Date(new java.util.Date().getTime());
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "SELECT SUM(g.vip_price * s.s_quantity),s.s_time  FROM goods g,sell_info s WHERE s.`s_c_number`=g.`c_number` and s.s_vip_number is not null";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Date date2 = rs.getDate(2);
				String utildate = sdf.format(date2);
				if (date1.toString().equals(utildate)) {
					money = money + rs.getDouble(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return money;
	}

	@Override
	public List<Sell> findtodaysell(Date date) {
		List<Sell> sells = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from sell_info where date(s_time)=?";
			ps = conn.prepareStatement(sql);
			ps.setDate(1, date);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sell sell = new Sell();
				sell.setGoodnumber(rs.getInt(1));
				sell.setQuantity(rs.getInt(2));
				sell.setSelltime(rs.getDate(3));
				sell.setEnumber(rs.getString(4));
				sell.setVipnumber(rs.getString(5));
				sells.add(sell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return sells;
	}

	@Override
	public List<Sell> findthisyear(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String dateString=sdf.format(date);
		List<Sell> sells = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from sell_info where YEAR(s_time)=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dateString);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sell sell = new Sell();
				sell.setGoodnumber(rs.getInt(1));
				sell.setQuantity(rs.getInt(2));
				sell.setSelltime(rs.getDate(3));
				sell.setEnumber(rs.getString(4));
				sell.setVipnumber(rs.getString(5));
				sells.add(sell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return sells;
	}

	@Override
	public List<Sell> findthismonth(String month) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		List<Sell> sells = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from sell_info where MONTH(s_time)=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, month);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sell sell = new Sell();
				sell.setGoodnumber(rs.getInt(1));
				sell.setQuantity(rs.getInt(2));
				sell.setSelltime(rs.getDate(3));
				sell.setEnumber(rs.getString(4));
				sell.setVipnumber(rs.getString(5));
				sells.add(sell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return sells;
	}

}
