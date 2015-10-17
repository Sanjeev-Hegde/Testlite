package com.testlite.controllers;

import java.net.UnknownHostException;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.testlite.model.JsonData;


@Controller
@EnableWebMvc
@RequestMapping("/JsonAction")
public class JsonController {
	@RequestMapping(value = "JsonGet",produces=MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public @ResponseBody JsonData getDummyDetails() {
	 //Persondetails  person = new Persondetails("Sanjeev",22);
      //  return person;
		JsonData jsonData= new JsonData("myjsonData");
		return jsonData;
    }
	@RequestMapping(value = "JsonPost", produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public @ResponseBody JsonData createEmployee(@RequestBody JsonData jsonData) {
		try {
			JSONObject jsonObj= new JSONObject(jsonData.getJsonString());
			//JSONArray the_json_array = jsonObj.getJSONArray("Scenarios");
			System.out.println(jsonObj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return jsonData;
 }
	@RequestMapping(value = "MongoGet/{name}",produces=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public @ResponseBody JsonData getDummyData(@PathVariable("name") String Name) {
	 //Persondetails  person = new Persondetails("Sanjeev",22);
      //  return person;
		try{
			MongoClient mongoClient = new MongoClient( "192.168.0.100" , 27017 );
			DB db = mongoClient.getDB( "education" );
			DBCollection coll = db.getCollection("userdata");
			
			///// inserting data into collection :working
			BasicDBObject doc = new BasicDBObject("jsonString", Name);
			coll.insert(doc);
			
			////////////////////////////////////////////////////
			
			
			///////// get the list of collection: working ////////
			/* 
			Set<String> tables = db.getCollectionNames();
			for(String coll : tables){
				System.out.println(coll);
			}*/
			//////////////////////////////////////////////////////
			
			
			// get first object from collection: working ///////////////
			/* 
			DBObject myDoc = coll.findOne();
			System.out.println(myDoc);*/
			/////////////////////////////////////////////////////
			
			/////// display all the documents in a collection: working
			DBCursor cursor = coll.find();
			try {
			   while(cursor.hasNext()) {
			       System.out.println(cursor.next());
			   }
			} finally {
			   cursor.close();
			}
			
			///////////////////////////////////////////////////////
			
		}
		catch(UnknownHostException u){
			System.out.println("cannot connect");
		} finally {
			//Always excecuted
		}
		JsonData jsonData= new JsonData("Mongo Data");
		return jsonData;
    }
	
}
