package com.cgm.hello_web_app.model;

public class Product {
	
	private String name;
	private double price;
	private String image;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, double price, String image) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
