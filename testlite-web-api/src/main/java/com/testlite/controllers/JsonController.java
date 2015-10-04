package com.testlite.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
	
}
