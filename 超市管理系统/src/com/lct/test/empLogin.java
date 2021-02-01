package com.lct.test;

import java.util.Scanner;

import com.lct.dao.IEmployeeDao;
import com.lct.dao.impl.EmployeeDaoImpl;
import com.lct.domain.Employee;

public class empLogin {

	public static void main(String[] args) {
		  login();

	}

	public static void login() {
		IEmployeeDao iemp= new EmployeeDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("*******欢迎管理员进入管理系统********");
		System.out.println("用户名:");
		String username=sc.nextLine();
		System.out.println("密码:");
		String password=sc.nextLine();
		Employee emp= iemp.login(username, password);
		if(emp!=null) {
			System.out.println("欢迎管理员-"+emp.getUsername()+"-进入管理系统");
			if(emp.getRole()==1) {
				System.out.println("*******欢迎管理员进入管理系统********");
				System.out.println("请选择您要进行的操作：");
				System.out.println("1.收银员账户管理");
				System.out.println("2.采购员账户管理");
				System.out.println("3.员工出勤管理");
				System.out.println("4.查询超市营业额");
				System.out.println("5.会员管理");
				System.out.println("6查询所有人员信息");
				System.out.println("7.上班打卡");
				System.out.println("8.下班打卡");
				System.out.println("退出界面");
			}
		}else {
			System.out.println("您的账号密码有误，请重新输入");
			login();
		}
	}
}
