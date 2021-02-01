package com.lct.service.impl;

import java.util.List;

import com.lct.dao.IVipDao;
import com.lct.dao.impl.VipDaoImpl;
import com.lct.domain.VIP;
import com.lct.service.IVipService;

public class VipServiceImpl implements IVipService {

	IVipDao v = new VipDaoImpl();

	@Override
	public int save(VIP vip) {
		return v.save(vip);
	}

	@Override
	public int delete(String vnum) {
		return v.delete(vnum);
	}

	@Override
	public int update(VIP vip) {
		return v.update(vip);
	}

	@Override
	public VIP getByVnum(String vnum) {
		return v.getByVnum(vnum);
	}

	@Override
	public List<VIP> findAllVip() {
		return v.findAllVip();
	}

	@Override
	public VIP viplogin(String loginname, String password) {
		return v.viplogin(loginname, password);
	}

}
