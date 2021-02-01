package com.lct.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.lct.dao.IVipDao;
import com.lct.dao.impl.VipDaoImpl;
import com.lct.domain.VIP;

class VipDaoImplTest {
     IVipDao v=new VipDaoImpl();
	@Test
	void testSave() {
     Date date=new Date();
     VIP vip=new VIP("vip666666","刘崇坦",6666,"124683",date);
     v.save(vip);
	}

	@Test
	void testDelete() {
		v.delete("vip201901020003");
	}

	@Test
	void testUpdate() {
		Date date=new Date();
		VIP vip=new VIP("vip666666","刘崇坦",4396,"124683",date);
		v.update(vip);
	}

	@Test
	void testGetByVnum() {
		System.out.println(v.getByVnum("vip666666"));
	}

	@Test
	void testFindAllVip() {
		List<VIP> vips=v.findAllVip();
		vips.forEach(vip->System.out.println(vip));
	}

	@Test
	void testViplogin() {
		String name="刘崇坦";
		String phone="124683";
		v.viplogin(name, phone);
	}

}
