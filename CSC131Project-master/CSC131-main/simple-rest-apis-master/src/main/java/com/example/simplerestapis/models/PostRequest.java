package com.example.simplerestapis.models;

public class PostRequest {
	int year;
	String name;
	public int getId() {
		return year;
	}
	public String getName() {
		return name;
	}
	public void setId(int year) {
		this.year = year;
	}
	public void setName(String name) {
		this.name = name;
	}

}
