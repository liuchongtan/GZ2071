package com.lct.test;

import com.lct.service.ISellService;
import com.lct.service.impl.SellServiceImpl;

public class test {
public static void main(String[] args) {
	ISellService sellService=new SellServiceImpl();
	System.out.println("总营业额:"+sellService.findallmoney());
}
}
