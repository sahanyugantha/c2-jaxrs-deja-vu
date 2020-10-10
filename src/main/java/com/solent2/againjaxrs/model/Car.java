package com.solent2.againjaxrs.model;

public class Car {
	
	private int id;
	private String model;
	private String brand;
	private int year;
	private CAR_TYPE type;
	
	public Car() {
	
	}

	public Car(int id, String model, String brand, int year, CAR_TYPE type) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.year = year;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public CAR_TYPE getType() {
		return type;
	}

	public void setType(CAR_TYPE type) {
		this.type = type;
	}
	
	
	
	

}
