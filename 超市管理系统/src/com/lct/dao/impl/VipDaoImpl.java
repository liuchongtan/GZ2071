package com.lct.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lct.dao.IVipDao;
import com.lct.domain.VIP;
import com.lct.utils.JDBCUtil;

public class VipDaoImpl implements IVipDao {

	@Override
	public int save(VIP vip) {
		String sql = "insert into vip values(?,?,?,?,?)";
		Object[] objects = { vip.getVnumber(), vip.getName(), vip.getScore(), vip.getPhone(), vip.getDate() };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public int delete(String vnum) {
		String sql = "delete from vip where v_number=? ";
		Object[] objects = { vnum };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public int update(VIP vip) {
		String sql = "update vip set v_name=?,v_score=?,v_phone=?,v_date=? where v_number=?";
		Object[] objects = { vip.getName(), vip.getScore(), vip.getPhone(), vip.getDate(), vip.getVnumber() };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public VIP getByVnum(String vnum) {
		VIP vip = new VIP();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from vip where v_number=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vnum);
			rs = ps.executeQuery();
			while (rs.next()) {
				vip.setVnumber(rs.getString("v_number"));
				vip.setName(rs.getString("v_name"));
				vip.setScore(rs.getInt("v_score"));
				vip.setPhone(rs.getString("v_phone"));
				vip.setDate(rs.getDate("v_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return vip;
	}

	@Override
	public List<VIP> findAllVip() {
		List<VIP> vips = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from vip";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				VIP vip = new VIP();
				vip.setVnumber(rs.getString("v_number"));
				vip.setName(rs.getString("v_name"));
				vip.setScore(rs.getInt("v_score"));
				vip.setPhone(rs.getString("v_phone"));
				vip.setDate(rs.getDate("v_date"));
				vips.add(vip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return vips;
	}

	@Override
	public VIP viplogin(String loginname, String password) {
		VIP vip = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from vip where v_name=? and v_phone=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginname);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				vip = new VIP();
				vip.setVnumber(rs.getString("v_number"));
				vip.setName(rs.getString("v_name"));
				vip.setScore(rs.getInt("v_score"));
				vip.setPhone(rs.getString("v_phone"));
				vip.setDate(rs.getDate("v_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return vip;
	}

}
