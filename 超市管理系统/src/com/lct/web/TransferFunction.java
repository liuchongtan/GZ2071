package com.lct.web;

import java.util.List;
import java.util.Scanner;

import com.lct.dao.IEmployeeDao;
import com.lct.domain.Good;
import com.lct.domain.Receipt;
import com.lct.test.ClockOp;
import com.lct.test.SellOp;
import com.lct.test.VipOp;
import com.lct.test.empOp;
import com.lct.test.goodOp;

public class TransferFunction {
	public static void function1(List<Receipt> receipts, SellOp sp, goodOp gp, VipOp vp, ClockOp cp, empOp ep,
			LoginSelect lsc, IEmployeeDao iemp, Scanner sc) {
		System.out.println("请输入要补货的商品号:");
		String goodnum = sc.nextLine();
		Good good = null;
		good = gp.getby(goodnum);
		String gnumber = good.getNumber();
		if (gnumber != null) {
			System.out.println("请输入要补货的数量:");
			int inventory = sc.nextInt();
			String test3 = sc.nextLine();
			Integer inventory2 = good.getInventory();
			inventory2 += inventory;
			good.setInventory(inventory2);
			gp.updategood(good);
			System.out.println("进货成功");
		} else if (gnumber == null) {
			System.out.println("请输入新的货物名字：");
			String goodname = sc.nextLine();
			System.out.println("请输入货物非会员价格");
			Double notvipprice = sc.nextDouble();
			String test10 = sc.nextLine();
			System.out.println("请输入货物的会员价格");
			Double vipprice = sc.nextDouble();
			String test11 = sc.nextLine();
			System.out.println("请输入进货数量");
			int inventory = sc.nextInt();
			good = new Good(goodnum, goodname, notvipprice, vipprice, inventory);
			gp.addgood(good);
			System.out.println("进货成功");
		}

	}
}
