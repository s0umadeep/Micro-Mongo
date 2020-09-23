package com.vit.db.jcomponent.microservicemongo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.vit.db.jcomponent.microservicemongo.model.ServiceSector;
@Service
public interface SectorsRepository extends JpaRepository<ServiceSector, Integer>{

}
