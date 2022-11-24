package com.marcaci.nbrigadistas.Brigada.empresarial.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import com.marcaci.nbrigadistas.Brigada.empresarial.model.Marcacion;

@Repository
public interface MarcacionRepository extends MongoRepository<Marcacion, Long>{

	@Query("{descripcion.'?O'}")
	List<Marcacion> findByDescripccion(String descripccion);
	
}
