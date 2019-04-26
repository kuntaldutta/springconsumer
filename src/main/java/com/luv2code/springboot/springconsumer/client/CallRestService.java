package com.luv2code.springboot.springconsumer.client;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springboot.springconsumer.model.Person;



@RestController
@RequestMapping("/persons")
public class CallRestService  {
	
	@RequestMapping("/v1/person")
	public String callRestService1(){
		
		RestTemplate restTemplate = new RestTemplate();
		Person person = restTemplate.getForObject("http://localhost:8888/v1/persons/1", Person.class);
		
		//System.out.println("The first name of the person is " + person.getFirstName());
		//System.out.println("The last name of the person is " + person.getLastName());
		return person.getFirstName();
		
	}
	
	@RequestMapping("/v2/person")
	public String callRestService2(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		Person person = restTemplate.getForObject("http://localhost:9999/v2/persons/2", Person.class);
		//System.out.println("The first name of the person is " + person.getFirstName());
		//System.out.println("The last name of the person is " + person.getLastName());
		return person.getFirstName();
		
	}

	

}
