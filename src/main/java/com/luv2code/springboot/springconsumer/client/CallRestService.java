package com.luv2code.springboot.springconsumer.client;


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

	
	@GetMapping("/v1/person")
	public String callRestService1(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		//Person person = restTemplate.getForObject("http://localhost:8888/v1/persons/1", Person.class);
		
		//Person person = restTemplate.getForObject(System.getenv("SpringBootApp_v1"),Person.class);
		
		String url = System.getenv("SPRING_SERVICE_HOST") + ":" +System.getenv("SPRING_SERVICE_PORT") + "/v1/persons/1";
		System.out.println("url : "+url);
		
		Person person = restTemplate.getForObject(url, Person.class);
		
		//System.out.println("The first name of the person is " + person.getFirstName());
		//System.out.println("The last name of the person is " + person.getLastName());
		return person.getFirstName();
		
	}
	
	@GetMapping("/v2/person")
	public String callRestService2(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		//Person person = restTemplate.getForObject("http://localhost:9999/v2/persons/2", Person.class);
		
     	
		//Person person = restTemplate.getForObject(environment.getProperty("person.v2.url"), Person.class);
	    
		String url1 = System.getenv("SPRING_SERVICE_HOST") + ":" +System.getenv("port_app2") + "/v2/persons/2";
		System.out.println("url1 : "+url1);
		
		Person person = restTemplate.getForObject(url1, Person.class);
		
		
		//Person person = restTemplate.getForObject(System.getenv("SpringBootApp_v2"), Person.class); 
		
		//System.out.println("The first name of the person is " + person.getFirstName());
		//System.out.println("The last name of the person is " + person.getLastName());
     	
		return person.getFirstName();
		
	}

	

}
