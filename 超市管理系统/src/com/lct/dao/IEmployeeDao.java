package com.lct.dao;

import java.util.List;

import com.lct.domain.Employee;

public interface IEmployeeDao {
	// 员工账号的增加方法
	public int save(Employee emp);

	// 员工账号的删除方法
	public int delete(String number);

	// 员工账号的修改方法
	public int update(Employee emp);

	// Employee根据number查询信息方法
	public Employee getByVnum(String number);

	// 查询全部员工
	public List<Employee> findAllemp();

	// 员工登录方法
	public Employee login(String username, String password);

	// 根据role获得rs
	public List<Employee> getByRole(int role);
}
