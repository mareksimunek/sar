package cz.fav.sar.server.dao;

import cz.fav.sar.server.domain.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long>{
	
}
