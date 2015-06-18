package com.example.restservicedemo.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car {
	
	private long id;
	private String make;
	private String model;	
	private int yop;
	private long owner;
	
	public Car(String make, String model, int yop, long owner) {
		this.make = make;
		this.model = model;
		this.yop = yop;
		this.owner = owner;
	}
	
	public Car(long id, String make, String model, int yop, long owner) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.yop = yop;
		this.owner = owner;
	}
	
	public Car() {
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}

	public long getOwner() {
		return owner;
	}
	public void setOwner(long owner) {
		this.owner = owner;
	}
}
