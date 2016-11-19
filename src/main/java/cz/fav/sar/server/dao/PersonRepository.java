package cz.fav.sar.server.dao;

import java.util.List;

import cz.fav.sar.server.domain.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	
	@Query("SELECT p FROM Person p WHERE LOWER(p.name) LIKE LOWER(:query) OR LOWER(p.surename) LIKE LOWER(:query)")
	public List<Person> findByQuery(@Param("query") String query);
}
