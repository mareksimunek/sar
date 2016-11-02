package cz.fav.sar.server.dao;

import cz.fav.sar.server.domain.Communication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends CrudRepository<Communication, Long>{
	
}
