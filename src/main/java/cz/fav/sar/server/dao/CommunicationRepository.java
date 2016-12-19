package cz.fav.sar.server.dao;

import cz.fav.sar.server.domain.Communication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunicationRepository extends CrudRepository<Communication, Long>{

    List<Communication> findByReportId(long customerId);
}
