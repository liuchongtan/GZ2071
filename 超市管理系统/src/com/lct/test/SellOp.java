package com.lct.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import com.lct.domain.Good;
import com.lct.domain.Sell;
import com.lct.service.IGoodService;
import com.lct.service.ISellService;
import com.lct.service.impl.GoodServiceImpl;
import com.lct.service.impl.SellServiceImpl;

public class SellOp {
	IGoodService igs=new GoodServiceImpl();
	public static void main(String[] args) {
		SellOp sp=new SellOp();
		sp.findtodaymoney();
	}
ISellService iss=new SellServiceImpl();
public void getallmoney() {
	System.out.println("总营业额是："+(iss.findallmoney()+iss.findallvipmoney()));
}
public void savesell(Sell sell) {
	iss.save(sell);
	System.out.println("添加商品成功");
}

public Double gettodaymoney(Date date) {
	Double double2 = iss.findtodayvip(date);
	return double2;
//	System.out.println("今日的营业额是："+double2);
	
}
public Double gettodaynotvipmoney(Date date) {
	Double double1=iss.findtodaynotvip(date);
	return double1;
}
public void findtodaymoney() {
	Double total=0.0d;
//	java.util.Date date=new java.util.Date();
	java.sql.Date date=new Date(System.currentTimeMillis());
	List<Sell> sells=iss.findtodaysell(date);
//	sells.forEach((sell)->System.out.println(sell));
	for(int i=0;i<sells.size();i++) {
		Good good=igs.getBynum(String.valueOf(sells.get(i).getGoodnumber()));
		if(sells.get(i).getVipnumber()==null) {
			total+=sells.get(i).getQuantity() * good.getPrice();
		}else {
			total+=sells.get(i).getQuantity() * good.getVipprice();
		}
	}
	System.out.println("今日销售额是："+total);
	
}
public void findthisyearmoney() {
	Double total=0.0d;
//	java.util.Date date=new java.util.Date();
	java.sql.Date date=new Date(System.currentTimeMillis());
	List<Sell> sells=iss.findthisyear(date);
//	sells.forEach((sell)->System.out.println(sell));
	for(int i=0;i<sells.size();i++) {
		Good good=igs.getBynum(String.valueOf(sells.get(i).getGoodnumber()));
		if(sells.get(i).getVipnumber()==null) {
			total+=sells.get(i).getQuantity() * good.getPrice();
		}else {
			total+=sells.get(i).getQuantity() * good.getVipprice();
		}
	}
	System.out.println("今年销售额是："+total);
}
public void findthismonthmoney(String month) {
	Double total=0.0d;
//	java.util.Date date=new java.util.Date();
	java.sql.Date date=new Date(System.currentTimeMillis());
	List<Sell> sells=iss.findthismonth(month);
//	sells.forEach((sell)->System.out.println(sell));
	for(int i=0;i<sells.size();i++) {
		Good good=igs.getBynum(String.valueOf(sells.get(i).getGoodnumber()));
		if(sells.get(i).getVipnumber()==null) {
			total+=sells.get(i).getQuantity() * good.getPrice();
		}else {
			total+=sells.get(i).getQuantity() * good.getVipprice();
		}
	}
	System.out.println("本月销售额是："+total);
}
public void findthisseasonmoney() {
	Double total=0.0d;
//	java.util.Date date=new java.util.Date();
	java.sql.Date date=new Date(System.currentTimeMillis());
	List<Sell> sells1=iss.findthismonth("7");
//	sells.forEach((sell)->System.out.println(sell));
	for(int j=0;j<sells1.size();j++) {
		Good good=igs.getBynum(String.valueOf(sells1.get(j).getGoodnumber()));
		if(sells1.get(j).getVipnumber()==null) {
			total+=sells1.get(j).getQuantity() * good.getPrice();
		}else {
			total+=sells1.get(j).getQuantity() * good.getVipprice();
		}
	}
	List<Sell> sells2=iss.findthismonth("8");
//	sells.forEach((sell)->System.out.println(sell));
	for(int j=0;j<sells2.size();j++) {
		Good good=igs.getBynum(String.valueOf(sells2.get(j).getGoodnumber()));
		if(sells2.get(j).getVipnumber()==null) {
			total+=sells2.get(j).getQuantity() * good.getPrice();
		}else {
			total+=sells2.get(j).getQuantity() * good.getVipprice();
		}
	}
	
	List<Sell> sells3=iss.findthismonth("9");
//	sells.forEach((sell)->System.out.println(sell));
	for(int j=0;j<sells3.size();j++) {
		Good good=igs.getBynum(String.valueOf(sells3.get(j).getGoodnumber()));
		if(sells3.get(j).getVipnumber()==null) {
			total+=sells3.get(j).getQuantity() * good.getPrice();
		}else {
			total+=sells3.get(j).getQuantity() * good.getVipprice();
		}
	}
	System.out.println("本季度销售额是:"+total);
}
	
}

