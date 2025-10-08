package com.reactive.ReactiveProject.Entity;

public class User {

	private String name;
	private String city;
	private String state;
	private String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	public User(String name, String city, String state, String country) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
