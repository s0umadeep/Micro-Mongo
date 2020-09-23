package com.vit.db.jcomponent.microservicemongo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Domain")
public class ServiceSectors {

	@Id
	String serviceId;
	List<ServiceSector> service;
	List<Attacks> attacks;

	/**
	 * @return the serviceId
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return the service
	 */
	public List<ServiceSector> getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(List<ServiceSector> service) {
		this.service = service;
	}

	/**
	 * @return the attacks
	 */
	public List<Attacks> getAttacks() {
		return attacks;
	}

	/**
	 * @param attacks the attacks to set
	 */
	public void setAttacks(List<Attacks> attacks) {
		this.attacks = attacks;
	}

	/**
	 * 
	 */
	public ServiceSectors() {
		super();
	}

	/**
	 * @param serviceId
	 * @param service
	 * @param attacks
	 */
	public ServiceSectors(String serviceId, List<ServiceSector> service, List<Attacks> attacks) {
		super();
		this.serviceId = serviceId;
		this.service = service;
		this.attacks = attacks;
	}

	@Override
	public String toString() {
		return "ServiceSectors [serviceId=" + serviceId + ", service=" + service + ", attacks=" + attacks + "]";
	}

}
