package com.lct.domain;

public class Employee {
	private String number;
	private String username;
	private String password;
	private String sex;
	private String phone;
	private Integer role;
	private Integer remark;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getRemark() {
		return remark;
	}

	public void setRemark(Integer remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Employee [number=" + number + ", username=" + username + ", password=" + password + ", sex=" + sex
				+ ", phone=" + phone + ", role=" + role + ", remark=" + remark + "]";
	}

	public Employee(String number, String username, String password, String sex, String phone, Integer role,
			Integer remark) {
		super();
		this.number = number;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.role = role;
		this.remark = remark;
	}

	public Employee() {
		super();
	}

}
