package com.lct.web;

import java.text.ParseException;
import java.util.Scanner;

public class LoginSelect {

	public static void main(String[] args) throws Exception {
		loginxuanze();
	}

	public static void loginxuanze() throws Exception {
		testvip t = new testvip();
		empLogin empl = new empLogin();
		// 选择登陆方式
		System.out.println("-------***超市管理系统***-------");
		System.out.println("1.会员登录 2.员工登录 3.退出系统");
		System.out.println("请选择您登录的身份:");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		if (i == 1) {
			t.viplog();
		} else if (i == 2) {
			empl.login();
		} else {
			System.out.println("成功退出系统");
		}
	}
}
