package cz.fav.sar.server.dao;

import cz.fav.sar.server.domain.System;
import org.springframework.data.repository.CrudRepository;

public interface SystemRepository extends CrudRepository<System, Long>{
	
}
