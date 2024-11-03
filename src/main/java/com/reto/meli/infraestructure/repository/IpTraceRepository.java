package com.reto.meli.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reto.meli.infraestructure.model.Iptrace;

@Repository
public interface IpTraceRepository  extends JpaRepository<Iptrace, Long>{
	
	@Query(nativeQuery = true, value = "select * from meli.iptrace i where i.pais =  ?1")
	public Iptrace findTraceByCountry(String country);

}
