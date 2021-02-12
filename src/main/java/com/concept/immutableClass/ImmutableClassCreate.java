package com.concept.immutableClass;

public final class ImmutableClassCreate {
	
	private Integer id;
	private String name;
	private String address;
	
	public ImmutableClassCreate(Integer id, String name, String address) {

		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Integer getId() {
		return id; 
	}

	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
}
