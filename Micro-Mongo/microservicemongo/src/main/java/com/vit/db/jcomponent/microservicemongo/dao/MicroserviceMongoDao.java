package com.vit.db.jcomponent.microservicemongo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vit.db.jcomponent.microservicemongo.model.ServiceSector;
import com.vit.db.jcomponent.microservicemongo.model.ServiceSectors;

@Repository
public interface MicroserviceMongoDao {

	public String putSectorsMongo(String id);
	
	public void putSectorsSQL(String id);
	
	public void postFilterSectors(String filteredName,String filteredID);

	public void postSectorsMongo(ServiceSectors sectors);

	public void postSectorsSql(List<ServiceSector> sectorsList);
	
	public void putSectorsSQL(String filteredName,String filteredID);

}
