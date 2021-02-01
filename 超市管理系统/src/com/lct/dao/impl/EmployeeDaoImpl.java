package com.lct.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lct.dao.IEmployeeDao;
import com.lct.domain.Employee;
import com.lct.utils.JDBCUtil;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public int save(Employee emp) {
		String sql = "insert into employee values(?,?,?,?,?,?,?)";
		Object[] objects = { emp.getNumber(), emp.getUsername(), emp.getPassword(), emp.getSex(), emp.getPhone(),
				emp.getRole(), emp.getRemark() };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public int delete(String number) {
		String sql = "delete from employee where number=?";
		Object[] objects = { number };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public int update(Employee emp) {
		String sql = "update employee set username=?,password=?,sex=?,phone=?,role=?,remark=? where number=?";
		Object[] objects = { emp.getUsername(), emp.getPassword(), emp.getSex(), emp.getPhone(), emp.getRole(),
				emp.getRemark(), emp.getNumber() };
		return JDBCUtil.executeupdate(sql, objects);
	}

	@Override
	public Employee getByVnum(String number) {
		Employee emp = new Employee();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from employee where number=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, number);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp.setNumber(rs.getString("number"));
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setSex(rs.getString("sex"));
				emp.setPhone(rs.getString("phone"));
				emp.setRole(rs.getInt("role"));
				emp.setRemark(rs.getInt("remark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return emp;
	}

	@Override
	public List<Employee> findAllemp() {
		List<Employee> emps = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from employee";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setNumber(rs.getString("number"));
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setSex(rs.getString("sex"));
				emp.setPhone(rs.getString("phone"));
				emp.setRole(rs.getInt("role"));
				emp.setRemark(rs.getInt("remark"));
				emps.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return emps;
	}

	@Override
	public Employee login(String username, String password) {
		Employee emp = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from employee where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee();
				emp.setNumber(rs.getString("number"));
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setSex(rs.getString("sex"));
				emp.setPhone(rs.getString("phone"));
				emp.setRole(rs.getInt("role"));
				emp.setRemark(rs.getInt("remark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return emp;
	}

	@Override
	public List<Employee> getByRole(int role) {
		List<Employee> emps = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getconn();
			String sql = "select * from employee where role=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, role);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setNumber(rs.getString("number"));
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setSex(rs.getString("sex"));
				emp.setPhone(rs.getString("phone"));
				emp.setRole(rs.getInt("role"));
				emp.setRemark(rs.getInt("remark"));
				emps.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAllresource(conn, ps, rs);
		}
		return emps;
	}

}
