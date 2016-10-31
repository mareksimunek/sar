package cz.fav.sar.server.dao;

import cz.fav.sar.server.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long>{
	
}
