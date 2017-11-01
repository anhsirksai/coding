package com.example.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.bookingDAO.PersonService;

import model.Person;

@SpringBootApplication
@ComponentScan("com.example")
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	  PersonService personService;

	Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public void run(String... args) {
	    Person person = new Person();
	    person.setFirstName("FName");
	    person.setLastName("LName");
	    person.setAge(20);
	    person.setPlace("Place");

	    if ( personService.addPerson(person) > 0){
	      logger.info("Person saved successfully");
	    }
	    
	    for(Person p : personService.getAllPerson()){
	        logger.info(p.toString());
	      }

	    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
