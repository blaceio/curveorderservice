package io.blace.microservices.curveorderservice.mongo.curveorder;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CurveOrderRepository extends MongoRepository<CurveOrder, String> {
	
	@Query(value = "{'matched': ?2, 'tradedate':{ $gt: ?0, $lt: ?1}}")
	List<CurveOrder> findByMatched( Date startdate, Date enddate, boolean matched, Sort sort);
	
	@Query(value = "{'client': '?0', 'matched': ?3, 'tradedate':{ $gt: ?1, $lt: ?2}}")
	List<CurveOrder> findByClientAndByMatched(String client, Date startdate, Date enddate, boolean matched, Sort sort);

}
