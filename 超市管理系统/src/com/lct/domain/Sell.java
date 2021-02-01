package com.lct.domain;

import java.util.Date;

public class Sell {
	private Integer goodnumber;
	private Integer quantity;
	private Date selltime;
	private String enumber;
	private String vipnumber;
	private Double allmoney;

	public Double getAllmoney() {
		return allmoney;
	}

	public void setAllmoney(Double allmoney) {
		this.allmoney = allmoney;
	}

	public Integer getGoodnumber() {
		return goodnumber;
	}

	public void setGoodnumber(Integer goodnumber) {
		this.goodnumber = goodnumber;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getSelltime() {
		return selltime;
	}

	public void setSelltime(Date selltime) {
		this.selltime = selltime;
	}

	public String getEnumber() {
		return enumber;
	}

	public void setEnumber(String enumber) {
		this.enumber = enumber;
	}

	public String getVipnumber() {
		return vipnumber;
	}

	public void setVipnumber(String vipnumber) {
		this.vipnumber = vipnumber;
	}

	@Override
	public String toString() {
		return "Sell [goodnumber=" + goodnumber + ", quantity=" + quantity + ", selltime=" + selltime + ", enumber="
				+ enumber + ", vipnumber=" + vipnumber + "]";
	}

	public Sell(Integer goodnumber, Integer quantity, Date selltime, String enumber, String vipnumber) {
		super();
		this.goodnumber = goodnumber;
		this.quantity = quantity;
		this.selltime = selltime;
		this.enumber = enumber;
		this.vipnumber = vipnumber;
	}

	public Sell() {
		super();
	}

}
