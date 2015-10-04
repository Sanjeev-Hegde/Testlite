package com.testlite.model;

public class JsonData {
	private String jsonString;
	public JsonData(){
		jsonString="";
	}
	public JsonData(String jsonString){
		this.jsonString=jsonString;
	}
	public String getJsonString(){
		return jsonString;
	}
	public void setJsonString(String jsonString){
		this.jsonString=jsonString;
	}
	@Override
	 public String toString() {
	  return "JsonData [jsonString=" + jsonString + "]";
	 }
}
