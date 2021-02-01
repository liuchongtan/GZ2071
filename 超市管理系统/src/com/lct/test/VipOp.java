package com.lct.test;

import java.util.List;

import com.lct.domain.VIP;
import com.lct.service.IVipService;
import com.lct.service.impl.VipServiceImpl;

public class VipOp {
IVipService ivip=new VipServiceImpl();

public void showAllVIP() {
	List<VIP> vips=ivip.findAllVip();
	System.out.println("-----------☆☆☆☆☆-------------");
	System.out.println("vip卡号"+"\t"+"vip名字"+"\t"+"vip积分"+"\t"+"vip电话"+"\t");
	for(int i=0;i<vips.size();i++) {
		System.out.println(vips.get(i).getVnumber()+"\t"+vips.get(i).getName()+"\t"+vips.get(i).getScore()+"\t"+vips.get(i).getPhone());
	}
}
public void deletevip(String vnum) {
	ivip.delete(vnum);
	System.out.println("删除成功");
}
public void updatevip(VIP vip) {
	ivip.update(vip);
	System.out.println("修改成功");
}
public void savevip(VIP vip) {
	ivip.save(vip);
	System.out.println("添加会员信息成功");
}
public VIP getbyvnum(String vnum) {
   return ivip.getByVnum(vnum);
}}
