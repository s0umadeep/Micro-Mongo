package com.vit.db.jcomponent.microservicemongo.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vit.db.jcomponent.microservicemongo.model.ServiceSectors;

@Service
public interface MicroserviceMongoService {

	public ServiceSectors createAttacks(String name, String id);

	public String getSectors(String id);
	
	public List<String> getFilterSector(String id);

	public ServiceSectors postSectors(ServiceSectors sectors);
	
	public List<String> postFileSectors(MultipartFile imageFile) throws FileNotFoundException;
	
	public List<ServiceSectors> getUnstructuredData();
}
