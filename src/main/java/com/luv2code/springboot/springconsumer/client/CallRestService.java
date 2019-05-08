package com.luv2code.springboot.springconsumer.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springboot.springconsumer.model.Person;



@RestController
@RequestMapping("/persons")
public class CallRestService  {
	
    /**
    * Autowiring environment.
    */
    //@Autowired
    //Environment environment;
	
	@Value("${restUrl1}")
	private String restUrl1;
	
	@Value("${restUrl2}")
	private String restUrl2;

	
	@GetMapping("/v1/person")
	public String callRestService1(){
		
		
		
		
		RestTemplate restTemplate = new RestTemplate();
		Person person = restTemplate.getForObject(restUrl1, Person.class);
		
		
		return person.getFirstName();
		
	}
	
	@GetMapping("/v2/person")
	public String callRestService2(){
		
		RestTemplate restTemplate = new RestTemplate();
		Person person = restTemplate.getForObject(restUrl2, Person.class);
		
		
		
		return person.getFirstName();
		
	}

	

}
