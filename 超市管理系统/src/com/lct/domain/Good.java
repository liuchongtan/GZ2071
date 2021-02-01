package com.lct.domain;

public class Good {
	private String number;
	private String name;
	private Double price;
	private Double vipprice;
	private Integer inventory;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getVipprice() {
		return vipprice;
	}

	public void setVipprice(Double vipprice) {
		this.vipprice = vipprice;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Good [number=" + number + ", name=" + name + ", price=" + price + ", vipprice=" + vipprice
				+ ", inventory=" + inventory + "]";
	}

	public Good(String number, String name, Double price, Double vipprice, Integer inventory) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.vipprice = vipprice;
		this.inventory = inventory;
	}

	public Good() {
		super();
	}

}
