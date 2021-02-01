package com.lct.domain;

import java.util.Date;

public class VIP {
	private String vnumber;
	private String name;
	private Integer score;
	private String phone;
	private Date date;

	public String getVnumber() {
		return vnumber;
	}

	public void setVnumber(String vnumber) {
		this.vnumber = vnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "VIP [vnumber=" + vnumber + ", name=" + name + ", score=" + score + ", phone=" + phone + ", date=" + date
				+ "]";
	}

	public VIP(String vnumber, String name, Integer score, String phone, Date date) {
		super();
		this.vnumber = vnumber;
		this.name = name;
		this.score = score;
		this.phone = phone;
		this.date = date;
	}

	public VIP() {
		super();
	}

}
