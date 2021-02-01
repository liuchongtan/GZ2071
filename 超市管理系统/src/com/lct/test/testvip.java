package com.lct.test;

import java.util.Scanner;

import com.lct.dao.IVipDao;
import com.lct.dao.impl.VipDaoImpl;
import com.lct.domain.VIP;
import com.lct.web.LoginSelect;

public class testvip {

	public static void main(String[] args) throws Exception {
		LoginSelect lgs=new LoginSelect();
		IVipDao v=new VipDaoImpl();
		//测试登录界面代码
		Scanner sc=new Scanner(System.in);
		System.out.println("-----------*******欢迎进入会员登录界面**********-------------------");
		System.out.println("姓名：");
		String name=sc.nextLine();
		System.out.println("手机号码：");
		String phone=sc.nextLine();
//        String name="东方不败";
//        String phone="15844760501";
        VIP vip = v.viplogin(name, phone);
        if(vip==null) {
    	System.out.println("名字或手机号码错误，登录失败");
    	lgs.loginxuanze();
        }else {
         System.out.println("欢迎"+vip.getName()+"进入会员中心");
         System.out.println("--------------------------------");
    	 System.out.println("请输入您要进行的操作:1.查看积分 2.退出");
    	 int i=sc.nextInt();
    	 if(i==1) {
    		 System.out.println("您的购物积分是："+vip.getScore());
    	 }
        }
//        if(vip==null) {
//        	System.out.println("登录失败");
//        }else {
//        	System.out.println("登录成功");
//        }

		
      		
//		VIP vip = v.getByVnum("vip201901020001");
//		System.out.println(vip);
	}

}
