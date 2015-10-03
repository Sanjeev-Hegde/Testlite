package com.testlite;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyApp {
	
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		Jsontest obj =(Jsontest)context.getBean("helloBean");
	
		obj.printHello();
		
	
		
	}
	
	
}
