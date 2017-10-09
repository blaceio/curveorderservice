package io.blace.microservices.curveorderservice.mongo.fixexec;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FIXExecutionReportRepository extends MongoRepository<FIXExecutionReport, String> {
	@Query(value = "{'tradedate':{ $gte: ?0, $lte: ?1}}")
	List<FIXExecutionReport> findAll( Date startdate, Date enddate, Sort sort);
}
