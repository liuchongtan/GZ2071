package com.lct.domain;

import java.util.Date;

public class Clock {
	private int id;
	private String empnum;
	private Date datein;
	private Date dateoff;
	private java.sql.Date day;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpnum() {
		return empnum;
	}

	public void setEmpnum(String empnum) {
		this.empnum = empnum;
	}

	public java.sql.Date getDay() {
		return day;
	}

	public void setDay(java.sql.Date day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Clock [id=" + id + ", empnum=" + empnum + ", datein=" + datein + ", dateoff=" + dateoff + ", day=" + day
				+ "]";
	}

	public Clock(int id, String empnum, Date datein, Date dateoff, java.sql.Date day) {
		super();
		this.id = id;
		this.empnum = empnum;
		this.datein = datein;
		this.dateoff = dateoff;
		this.day = day;
	}

	public Clock() {
		super();
	}

	public Clock(String empnum, Date datein, Date dateoff, java.sql.Date day) {
		super();
		this.empnum = empnum;
		this.datein = datein;
		this.dateoff = dateoff;
		this.day = day;
	}

}
