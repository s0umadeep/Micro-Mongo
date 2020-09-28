package com.vit.db.jcomponent.microservicemongo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.vit.db.jcomponent.microservicemongo.dao.DomainRepository;
import com.vit.db.jcomponent.microservicemongo.dao.MicroserviceMongoDao;
import com.vit.db.jcomponent.microservicemongo.model.Attacks;
import com.vit.db.jcomponent.microservicemongo.model.ServiceSector;
import com.vit.db.jcomponent.microservicemongo.model.ServiceSectors;

@Component
public class MicroserviceMongoServiceImpl implements MicroserviceMongoService {

	public static Log log;
	
	@Autowired
	DomainRepository domainRepository;
	
	@Autowired
	MicroserviceMongoDao microserviceMongo;
	
	@Override
	public ServiceSectors createAttacks(String name, String id) {
		ServiceSectors sectors = new ServiceSectors();
		if(!name.isEmpty() && id.isEmpty()) {
			ServiceSector sector = new ServiceSector("1111", name, "Pune");
			List<ServiceSector> service = new ArrayList<ServiceSector>();
			service.add(sector);
			sectors.setService(service);
		}
		else if (name.isEmpty() && !id.isEmpty()) {
			ServiceSector sector = new ServiceSector(id, "VIT Project", "Vellore");
			List<ServiceSector> service = new ArrayList<ServiceSector>();
			service.add(sector);
			sectors.setService(service);
		}
		else if(!name.isEmpty() && !id.isEmpty()) {
			List<ServiceSector> service = new ArrayList<ServiceSector>();
			List<Attacks> attacksList = new ArrayList<>();
			ServiceSector sector = new ServiceSector(id, name, "Earth");
			Attacks attacks = new Attacks("Man in Middle attack", 5.766f, "High");
			attacksList.add(attacks);
			sector.setSectorId(id);
			service.add(sector);
			sectors.setServiceId("888");
			sectors.setService(service);
			sectors.setAttacks(attacksList);
		}
		return sectors;
	}

	@Override
	public String getSectors(String id) {
		
		String filteredId = id;
		// Filter Logic;
		
		// save into mongoDB
		microserviceMongo.putSectorsMongo(filteredId);
		
		//save into MYSQLDB
		microserviceMongo.putSectorsSQL(filteredId);
		
		return id;

	}

	@Override
	public ServiceSectors postSectors(ServiceSectors sectors) {

		ServiceSectors serviceSectors = new ServiceSectors();
		List<ServiceSector> sectorsList = new ArrayList<ServiceSector>();
		
		if(sectors!=null) {
			if (sectors.getService()!=null || !sectors.getService().isEmpty()) {
				
				for (ServiceSector serviceSect : sectors.getService()) {
					sectorsList.add(serviceSect);
					}				
				microserviceMongo.postSectorsSql(sectorsList);			
			}
			if(!sectors.getAttacks().isEmpty() && !sectors.getService().isEmpty()) {
				
			// save into mongoDB
			microserviceMongo.postSectorsMongo(sectors);
			serviceSectors = sectors;
			}
		}else {
			System.out.println("Sectors Data Not Found !!!");
		}
		return serviceSectors;
	}

	@Override
	public List<String> getFilterSector(String id) {
		File f = new File("D:\\CODE\\Xml\\Testing.xml");
		List<String> Reader = new ArrayList<String>();
		try (Scanner sc = new Scanner(f)) {
			boolean fn = false, fi = false;
			String data = "", data1 = "", FilteredName = "", FilteredID = "";
			while (sc.hasNextLine()) {
				String unfiltereddata = sc.nextLine();
				Pattern p = Pattern
						.compile("<[anfopcANFOPC][a-zA-Z_-]*[erER]>[a-zA-Z,_']*</[anfopcANFOPC][a-zA-Z_-]*[erER]>"); // ,
																														// '
																														// remove
				data = unfiltereddata.trim();
				Matcher m = p.matcher(data.replace(" ", "_"));
				boolean b = m.matches();

				Pattern p2 = Pattern.compile(
						"<[ucisnfoptUCISNFOPT][a-zA-Z_-]*[doDO.]>[a-zA-Z,_'0-9]*</[ucisnfoptUCISNFOPT][a-zA-Z_-]*[doDO.]>");
				data1 = unfiltereddata.trim();
				Matcher m2 = p2.matcher(data.replace(" ", "_"));
				boolean c = m2.matches();
				if (c) {
					fi = true;
					int x = data1.indexOf(">");
					int y = data1.lastIndexOf("<");
					FilteredID = data1.substring(x + 1, y);
				}
				if (b) {
					fn = true;
					int x = data.indexOf(">");
					int y = data.lastIndexOf("<");
					FilteredName = data.substring(x + 1, y);
				}
				if (fi && fn) {
					fn = false;
					fi = false;
					microserviceMongo.postFilterSectors(FilteredName, FilteredID);
					Reader.add("Name: " + FilteredName + "\nID :" + FilteredID);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Reader;

	}
	
	@Override
	public List<String> postFileSectors(MultipartFile imageFile) {
		String content = null;
		try {
			content = new String(imageFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> Reader = new ArrayList<String>();

		try (Scanner sc = new Scanner(content)) {
			boolean fn = false, fi = false;
			String data = "", data1 = "", FilteredName = "", FilteredID = "";
			while (sc.hasNextLine()) {

				String unfiltereddata = sc.nextLine();
				Pattern p = Pattern
						.compile("<[anfopcANFOPC][a-zA-Z_-]*[erER]>[a-zA-Z,_']*</[anfopcANFOPC][a-zA-Z_-]*[erER]>"); // ,
																														// '
																														// remove
				data = unfiltereddata.trim();
				Matcher m = p.matcher(data.replace(" ", "_"));
				boolean b = m.matches();

				Pattern p2 = Pattern.compile(
						"<[ucisnfoptUCISNFOPT][a-zA-Z_-]*[doDO.]>[a-zA-Z,_'0-9]*</[ucisnfoptUCISNFOPT][a-zA-Z_-]*[doDO.]>");
				data1 = unfiltereddata.trim();
				Matcher m2 = p2.matcher(data.replace(" ", "_"));
				boolean c = m2.matches();

				if (c) {
					fi = true;
					int x = data1.indexOf(">");
					int y = data1.lastIndexOf("<");
					FilteredID = data1.substring(x + 1, y);

				}
				if (b) {
					fn = true;
					int x = data.indexOf(">");
					int y = data.lastIndexOf("<");
					FilteredName = data.substring(x + 1, y);

				}
				if (fi && fn) {
					fn = false;
					fi = false;
					microserviceMongo.putSectorsSQL(FilteredName, FilteredID);
					Reader.add("Name: " + FilteredName + "\nID :" + FilteredID);
				}
			}
		}
		return Reader;

	}
}

