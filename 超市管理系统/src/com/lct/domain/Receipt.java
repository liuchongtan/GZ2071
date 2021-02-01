package com.lct.domain;

public class Receipt {
	private Integer goodnum;
	private Integer quantity;
	private Boolean flag;

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Integer getGoodnum() {
		return goodnum;
	}

	public void setGoodnum(Integer goodnum) {
		this.goodnum = goodnum;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Receipt(Integer goodnum, Integer quantity) {
		super();
		this.goodnum = goodnum;
		this.quantity = quantity;
	}

	public Receipt() {
		super();
	}

	@Override
	public String toString() {
		return "Receipt [goodnum=" + goodnum + ", quantity=" + quantity + "]";
	}

}
