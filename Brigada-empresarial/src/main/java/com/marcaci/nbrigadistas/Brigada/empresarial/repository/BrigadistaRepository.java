package com.marcaci.nbrigadistas.Brigada.empresarial.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.marcaci.nbrigadistas.Brigada.empresarial.model.Brigadistas;

@Repository
public interface BrigadistaRepository extends MongoRepository<Brigadistas, Long> {

	@Query("{descripcion.'?0'}")
	List<Brigadistas> findByDescripccion(String descripccion);
}

