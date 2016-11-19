package cz.fav.sar.server.dao;

import java.util.List;

import cz.fav.sar.server.domain.Company;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long>{
	@Query("SELECT c FROM Company c WHERE LOWER(c.name) LIKE LOWER(:query)")
	public List<Company> findByQuery(@Param("query") String query);
}
