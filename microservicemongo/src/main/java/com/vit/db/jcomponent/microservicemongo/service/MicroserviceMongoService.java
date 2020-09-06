package com.vit.db.jcomponent.microservicemongo.service;

import org.springframework.stereotype.Service;

import com.vit.db.jcomponent.microservicemongo.model.ServiceSectors;

@Service
public interface MicroserviceMongoService {

	public ServiceSectors createAttacks(String name, int id);


}
