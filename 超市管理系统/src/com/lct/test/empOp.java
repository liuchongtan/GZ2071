package com.lct.test;

import java.util.List;

import com.lct.dao.IEmployeeDao;
import com.lct.dao.impl.EmployeeDaoImpl;
import com.lct.domain.Employee;

public class empOp {
	IEmployeeDao iemp=new EmployeeDaoImpl();
    public void registeremp(Employee emp) {
	 int row=iemp.save(emp);
	 if(row>0) {
		 System.out.println("注册成功");
	 }else {
		 System.out.println("注册失败");
	 }
 }
    public void deleteemp(String number) {
    	int row = iemp.delete(number);
    	if(row>0) {
    		System.out.println("删除管理员编号"+number+"成功！");
    	}else {
    		System.out.println("管理员编号不存在,删除失败！");
    	}
    }
    public void updateemp(Employee emp) {
    	int row = iemp.update(emp);
    	if(row>0) {
    		System.out.println("修改管理员信息成功!");
    	}else {
    		System.out.println("修改失败!");
    	}
    }
    public void listallemp() {
    	List<Employee> emps = iemp.findAllemp();
    	System.out.println("-----------☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆-------------");
    	System.out.println("职工编号"+"\t"+"用户名"+"\t"+"密码"+"\t"+"性别"+"\t"+"电话");
    	for(int i=0;i<emps.size();i++) {
    		System.out.println(emps.get(i).getNumber()+"\t"+emps.get(i).getUsername()+"\t"+emps.get(i).getPassword()+"\t"+emps.get(i).getSex()+"\t"+emps.get(i).getPhone());
    }}
    public void listroleemp(int role) {
    	List<Employee> emps = iemp.getByRole(role);
    	System.out.println("-----------☆☆☆☆☆-------------");
    	System.out.println("职工编号"+"\t"+"用户名"+"\t"+"密码"+"\t"+"性别"+"\t"+"电话");
    	for(int i=0;i<emps.size();i++) {
    		System.out.println(emps.get(i).getNumber()+"\t"+emps.get(i).getUsername()+"\t"+emps.get(i).getPassword()+"\t"+emps.get(i).getSex()+"\t"+emps.get(i).getPhone());
    	}
//    	emps.forEach(emp->System.out.println(emp));
    }
    public Employee getBynumber(String number) {
    	Employee emp = iemp.getByVnum(number);
    	return emp;
    }
}
