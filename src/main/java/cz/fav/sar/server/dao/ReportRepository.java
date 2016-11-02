package cz.fav.sar.server.dao;

import cz.fav.sar.server.domain.Report;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long>{
	
}
