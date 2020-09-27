package com.vit.db.jcomponent.microservicemongo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Service")
public class ServiceSector {

	@Id
	String sectorId;
	String sectorName;
	String sectorLocation;

	/**
	 * @return the sectorId
	 */
	public String getSectorId() {
		return sectorId;
	}

	/**
	 * @param sectorId the sectorId to set
	 */
	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	/**
	 * @return the sectorName
	 */
	public String getSectorName() {
		return sectorName;
	}

	/**
	 * @param sectorName the sectorName to set
	 */
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	/**
	 * @return the sectorLocation
	 */
	public String getSectorLocation() {
		return sectorLocation;
	}

	/**
	 * @param sectorLocation the sectorLocation to set
	 */
	public void setSectorLocation(String sectorLocation) {
		this.sectorLocation = sectorLocation;
	}

	/**
	 * @param sectorId
	 * @param sectorName
	 * @param sectorLocation
	 */
	public ServiceSector(String sectorId, String sectorName, String sectorLocation) {
		super();
		this.sectorId = sectorId;
		this.sectorName = sectorName;
		this.sectorLocation = sectorLocation;
	}

	/**
	 * 
	 */
	public ServiceSector() {
		super();
	}

	@Override
	public String toString() {
		return "ServiceSector [sectorId=" + sectorId + ", sectorName=" + sectorName + ", sectorLocation="
				+ sectorLocation + "]";
	}

}
