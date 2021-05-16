package com.nitinjyoti.test;

import org.springframework.stereotype.Component;

@Component
public class TestBean {
	private int id;
	private String name;
	
	public TestBean() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TestBean(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "TestBean [id=" + id + ", name=" + name + "]";
	}
	
	
}
