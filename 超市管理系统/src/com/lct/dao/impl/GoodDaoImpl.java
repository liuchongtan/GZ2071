package com.lct.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lct.dao.IGoodDao;
import com.lct.domain.Good;
import com.lct.utils.JDBCUtil;

public class GoodDaoImpl implements IGoodDao {

	@Override
	public int save(Good good) {
		String sql = "insert into goods values(?,?,?,?,?)";
		Object[] objects = { good.getNumber(), good.getName(), good.getPrice(), good.getVipprice(),
				good.getInventory() };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public int delete(String number) {
		String sql = "delete from goods where c_number=?";
		Object[] objects = { number };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public int update(Good good) {
		String sql = "update goods set c_name=?,c_price=?,vip_price=?,inventory=? where c_number=?";
		Object[] objects = { good.getName(), good.getPrice(), good.getVipprice(), good.getInventory(),
				good.getNumber() };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public Good getBynum(String number) {
		Good good = new Good();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from goods where c_number=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, number);
			rs = ps.executeQuery();
			while (rs.next()) {
				good.setNumber(rs.getString("c_number"));
				good.setName(rs.getString("c_name"));
				good.setPrice(rs.getDouble("c_price"));
				good.setVipprice(rs.getDouble("vip_price"));
				good.setInventory(rs.getInt("inventory"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return good;
	}

	@Override
	public List<Good> findAllVip() {
		List<Good> goods = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from goods";
			rs = ps.executeQuery();
			while (rs.next()) {
				Good good = new Good();
				good.setNumber(rs.getString("c_number"));
				good.setName(rs.getString("c_name"));
				good.setPrice(rs.getDouble("c_price"));
				good.setVipprice(rs.getDouble("vip_price"));
				good.setInventory(rs.getInt("inventory"));
				goods.add(good);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return goods;
	}

	@Override
	public List<Good> listlessGoods() {
		List<Good> goods = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from goods where inventory <?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 100);
			rs = ps.executeQuery();
			while (rs.next()) {
				Good good = new Good();
				good.setNumber(rs.getString("c_number"));
				good.setName(rs.getString("c_name"));
				good.setPrice(rs.getDouble("c_price"));
				good.setVipprice(rs.getDouble("vip_price"));
				good.setInventory(rs.getInt("inventory"));
				goods.add(good);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return goods;
	}

}
