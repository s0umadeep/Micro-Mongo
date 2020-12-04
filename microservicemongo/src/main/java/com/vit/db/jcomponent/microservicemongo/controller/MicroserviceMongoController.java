package com.vit.db.jcomponent.microservicemongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vit.db.jcomponent.microservicemongo.model.ServiceSectors;
import com.vit.db.jcomponent.microservicemongo.service.MicroserviceMongoService;

@Component
@RestController
public class MicroserviceMongoController {

	@Autowired
	MicroserviceMongoService microservicemongo;

	@GetMapping("/Microservice/Attack/{name}/{id}")
	ServiceSectors createAttack(@PathVariable("name") String name, @PathVariable("id") String id) {
		return microservicemongo.createAttacks(name, id);
	}

	@GetMapping("/Microservice/Attack/{id}")
	String getSectors(@PathVariable("id") String id) {
		return microservicemongo.getSectors(id);
	}

	@GetMapping("/Microservice/Attack/Filter/{id}") // received by database (mysql)
	List<String> getFilterSector(@PathVariable("id") String id) {
		return microservicemongo.getFilterSector(id);
	}
	
		
	@PostMapping("/Microservice/Attack/upload") // received file by database (mysql) for XML code
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		@SuppressWarnings("unused")
		String message = null;
		try {
			microservicemongo.postFileSectors(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new String("Uploaded Successfully"));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new String("Operation Failed"));
		}
	}
	
	@PostMapping("/Microservice/Attack/UnstructeredData") // received file by database (mongodb) for JSON code
	ServiceSectors postSectors(@RequestBody ServiceSectors sectors) {
		return microservicemongo.postSectors(sectors);
	}

	@GetMapping("/Microservice/Attack/getUnstructeredData") // get data from Mongo DB
	List<ServiceSectors> getUnstructuredData() {
		return microservicemongo.getUnstructuredData();
	}
}
