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

	
	@GetMapping("/1")
	public String callRestService1(){
		
		System.out.println();
		
		
		RestTemplate restTemplate = new RestTemplate();
		String person = restTemplate.getForObject(restUrl1, String.class);
		
		
		return person;
		
	}
	
	@GetMapping("/2")
	public String callRestService2(){
		
		RestTemplate restTemplate = new RestTemplate();
		String person = restTemplate.getForObject(restUrl2, String.class);
		
		
		
		return person;
		
	}

	

}
