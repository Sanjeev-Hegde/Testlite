package com.testlite.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.testlite.model.Persondetails;


@Controller
@EnableWebMvc
@RequestMapping("/JsonAction")
public class JsonController {
	@RequestMapping(value = "JsonGet",produces=MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public @ResponseBody Persondetails getDummyDetails() {
	 Persondetails  person = new Persondetails("Sanjeev",22);
        return person;
    }
	@RequestMapping(value = "JsonPost", produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public @ResponseBody Persondetails createEmployee(@RequestBody Persondetails emp) {
		Persondetails  person = new Persondetails("Sanjeev",22);
        return person;
 }
	
}
