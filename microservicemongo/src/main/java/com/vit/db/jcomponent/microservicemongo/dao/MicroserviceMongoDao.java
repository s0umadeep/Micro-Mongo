package com.vit.db.jcomponent.microservicemongo.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface MicroserviceMongoDao {

	public String putSectorsMongo(String id);
	
	public void putSectorsSQL(String id);

}
