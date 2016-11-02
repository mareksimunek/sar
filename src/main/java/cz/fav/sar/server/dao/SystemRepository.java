package cz.fav.sar.server.dao;

import cz.fav.sar.server.domain.System;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends CrudRepository<System, Long>{
	
}
