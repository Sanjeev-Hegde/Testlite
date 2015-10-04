package com.testlite.model;

public class Persondetails {
	private String name;
	private int age;
	
	public Persondetails(){
		this.name="sanjeev";
		this.age=22;
	}
	public Persondetails(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return age;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setAge(int age){
		this.age=age;
	}
	@Override
	 public String toString() {
	  return "Persondata [name=" + name + ", age=" + age + "]";
	 }

}
