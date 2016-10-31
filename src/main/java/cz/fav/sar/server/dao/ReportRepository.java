package cz.fav.sar.server.dao;

import cz.fav.sar.server.domain.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Long>{
	
}
