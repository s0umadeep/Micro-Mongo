package com.vit.db.jcomponent.microservicemongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vit.db.jcomponent.microservicemongo.model.ServiceSector;
import com.vit.db.jcomponent.microservicemongo.model.ServiceSectors;

@Repository
public class MicroserviceMongoDaoImpl implements MicroserviceMongoDao {

	@Autowired
	DomainRepository domainRepository;

	@Autowired
	SectorsRepository serviceRepository;

	@Override
	public String putSectorsMongo(String id) {
		ServiceSectors serviceSectors = new ServiceSectors();

		serviceSectors.setServiceId(id);
		domainRepository.insert(serviceSectors);
		return serviceSectors.getServiceId();
	}

	@Override
	public void putSectorsSQL(String id) {
		ServiceSector serviceSector = new ServiceSector();
		serviceSector.setSectorName(id);;
		serviceRepository.save(serviceSector);
	}

}
