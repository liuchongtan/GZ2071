package com.lct.dao.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.lct.dao.IEmployeeDao;
import com.lct.dao.impl.EmployeeDaoImpl;
import com.lct.domain.Employee;

class EmployeeDaoImplTest {
    IEmployeeDao iemp=new EmployeeDaoImpl();
	@Test
	void testSave() {
		Employee emp=new Employee("S0012", "刘崇坦", "124683", "男", "13530815736", 1, 1);
		iemp.save(emp);
	}

	@Test
	void testDelete() {
		iemp.delete("S0011");
	}

	@Test
	void testUpdate() {
		Employee emp=new Employee("S0012", "坦子哥", "124683", "男", "13530815736", 1, 1);
		iemp.update(emp);
	}

	@Test
	void testGetByVnum() {
		System.out.println(iemp.getByVnum("S0012"));
	}

	@Test
	void testFindAllVip() {
		List<Employee> emps=iemp.findAllemp();
		emps.forEach(emp->System.out.println(emp));
	}

	@Test
	void testViplogin() {
		String username="坦子哥";
		String password="124683";
		Employee emp1=iemp.login(username, password);
		System.out.println(emp1);
	}

}
