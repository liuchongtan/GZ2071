package com.lct.test;

import java.util.List;

import com.lct.domain.Good;
import com.lct.service.IGoodService;
import com.lct.service.impl.GoodServiceImpl;

public class goodOp {
IGoodService igs=new GoodServiceImpl();

public void selectlessgood() {
	List<Good> goods = igs.listlessGoods();
	System.out.println("-----------☆☆☆☆☆-------------");
	System.out.println("货物号"+"\t"+"货物名字"+"\t"+"货物库存");
	for(int i=0;i<goods.size();i++) {
		System.out.println(goods.get(i).getNumber()+"\t"+goods.get(i).getName()+"\t"+goods.get(i).getInventory());
	}
}
public Good getby(String number) {
	Good good=igs.getBynum(number);
	return good;
}
public void updategood(Good good) {
	igs.update(good);
}
public void addgood(Good good) {
	igs.save(good);
}
}
