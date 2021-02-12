package com.concept.finalPackage;

public final class AFinalClass {
	
	private int id;
	private String name;
	private String addr;
	private String city;
	
	public AFinalClass() {
		
	}
	
	public AFinalClass(int id, String name, String addr, String city) {
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.city = city;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public String getCity() {
		return city;
	}
}
