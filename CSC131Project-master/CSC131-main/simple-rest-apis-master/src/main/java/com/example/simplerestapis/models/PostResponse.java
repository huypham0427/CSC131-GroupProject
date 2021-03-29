package com.example.simplerestapis.models;

public class PostResponse {
	int year;
	String message;
	String extra;
	public String getExtra() {
		return extra;
	}
	public int getId() {
		return year;
	}
	public String getMessage() {
		return message;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public void setId(int year) {
		this.year = year;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
