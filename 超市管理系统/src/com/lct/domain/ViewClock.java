package com.lct.domain;

import java.util.Date;

public class ViewClock {
	private java.sql.Date workdate;
	private String empnumber;
	private Date datein;
	private Date dateoff;
	private String chidao;
	private String zaotui;

	public java.sql.Date getWorkdate() {
		return workdate;
	}

	public void setWorkdate(java.sql.Date workdate) {
		this.workdate = workdate;
	}

	public String getEmpnumber() {
		return empnumber;
	}

	public void setEmpnumber(String empnumber) {
		this.empnumber = empnumber;
	}

	public Date getDatein() {
		return datein;
	}

	public void setDatein(Date datein) {
		this.datein = datein;
	}

	public Date getDateoff() {
		return dateoff;
	}

	public void setDateoff(Date dateoff) {
		this.dateoff = dateoff;
	}

	public String getChidao() {
		return chidao;
	}

	public void setChidao(String chidao) {
		this.chidao = chidao;
	}

	public String getZaotui() {
		return zaotui;
	}

	public void setZaotui(String zaotui) {
		this.zaotui = zaotui;
	}

	@Override
	public String toString() {
		return "ViewClock [打卡日期=" + workdate + ", 员工编号=" + empnumber + ", 上班打卡=" + datein + ", 下班打卡=" + dateoff
				+ ", 上班打卡=" + chidao + ", 下班打卡=" + zaotui + "]";
	}

	public ViewClock(java.sql.Date workdate, String empnumber, Date datein, Date dateoff, String chidao,
			String zaotui) {
		super();
		this.workdate = workdate;
		this.empnumber = empnumber;
		this.datein = datein;
		this.dateoff = dateoff;
		this.chidao = chidao;
		this.zaotui = zaotui;
	}

	public ViewClock() {
		super();
	}

}
