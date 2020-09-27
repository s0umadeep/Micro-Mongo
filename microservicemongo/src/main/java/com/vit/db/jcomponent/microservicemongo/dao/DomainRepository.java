package com.vit.db.jcomponent.microservicemongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vit.db.jcomponent.microservicemongo.model.ServiceSectors;

public interface DomainRepository extends MongoRepository<ServiceSectors, String>{

}
