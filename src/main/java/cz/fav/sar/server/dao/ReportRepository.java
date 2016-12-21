package cz.fav.sar.server.dao;

import java.util.List;

import cz.fav.sar.server.domain.Report;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long>{
	List<Report> findByCustomerId(long customerId);
	List<Report> findBySolvingUserCode(String userCode);
	@Query("SELECT r FROM Report r WHERE (r.solvingUserCode = :userCode) AND (r.solutionDate is NULL)")
	List<Report> findSolverUnresolvedReports(@Param("userCode") String userCode);
	@Query("SELECT r FROM Report r WHERE (r.solvingUserCode = :userCode) AND (r.solutionDate IS NOT NULL)")
	List<Report> findSolverResolvedReports(@Param("userCode") String userCode);
	@Query("SELECT r FROM Report r WHERE (r.customerId = :customerId) AND (r.solutionDate is NULL)")
	List<Report> findUnresolvedReports(@Param("customerId") long customerId);
	@Query("SELECT r FROM Report r WHERE (r.customerId = :customerId) AND (r.solutionDate is NOT NULL)")
	List<Report> findResolvedReports(@Param("customerId") long customerId);
}
