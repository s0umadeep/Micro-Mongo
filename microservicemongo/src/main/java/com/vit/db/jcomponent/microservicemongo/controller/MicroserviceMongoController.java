package com.vit.db.jcomponent.microservicemongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vit.db.jcomponent.microservicemongo.model.ServiceSectors;
import com.vit.db.jcomponent.microservicemongo.service.MicroserviceMongoService;

@Component
@RestController
public class MicroserviceMongoController {

	@Autowired
	MicroserviceMongoService microservicemongo;
	
	@GetMapping("/Microservice/Attack/{name}/{id}")

	ServiceSectors createAttack(@PathVariable("name") String name ,@PathVariable("id") int id) {
		return microservicemongo.createAttacks(name,id);
	}
	
}
