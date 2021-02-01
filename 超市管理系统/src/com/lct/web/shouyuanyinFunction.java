package com.lct.web;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.lct.dao.IEmployeeDao;
import com.lct.domain.Good;
import com.lct.domain.Receipt;
import com.lct.domain.Sell;
import com.lct.domain.VIP;
import com.lct.test.ClockOp;
import com.lct.test.SellOp;
import com.lct.test.VipOp;
import com.lct.test.empOp;
import com.lct.test.goodOp;

public class shouyuanyinFunction {
	public static void function2(List<Receipt> receipts, SellOp sp, goodOp gp, VipOp vp, ClockOp cp, empOp ep,
			LoginSelect lsc, IEmployeeDao iemp, Scanner sc) {
		System.out.println("请输入您要查询的会员卡号:");
		String vipnum = sc.nextLine();
		VIP vip = vp.getbyvnum(vipnum);
		Integer score = vip.getScore();
		String vipname = vip.getName();
		System.out.println("-----------☆☆☆☆☆-------------");
		System.out.println("你所查询的会员名字是：" + vipname);
		System.out.println("你所查询的会员积分为：" + score);
	}

	public static void function3(List<Receipt> receipts, SellOp sp, goodOp gp, VipOp vp, ClockOp cp, empOp ep,
			LoginSelect lsc, IEmployeeDao iemp, Scanner sc) {
		System.out.println("请输入你要增加会员的信息用空格分开(vip编号 vip名字 vip积分 vip电话)");
		String vipnum = sc.next();
		String vipname = sc.next();
		int vipscore = sc.nextInt();
		String vipphone = sc.next();
		String test = sc.nextLine();
		Date date1 = new Date();
		java.sql.Date date = new java.sql.Date(date1.getTime());
		VIP vip = new VIP(vipnum, vipname, vipscore, vipphone, date);
		vp.savevip(vip);
	}

}
