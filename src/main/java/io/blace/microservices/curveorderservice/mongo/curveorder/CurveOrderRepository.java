package io.blace.microservices.curveorderservice.mongo.curveorder;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CurveOrderRepository extends MongoRepository<CurveOrder, String> {
	
	@Query(value = "{'tradedate':{ $gte: ?0, $lte: ?1}}")
	List<CurveOrder> findAll( Date startdate, Date enddate, Sort sort);
	
	@Query(value = "{'client': '?0', 'tradedate':{ $gte: ?1, $lte: ?2}}")
	List<CurveOrder> findByClient(String client, Date startdate, Date enddate, Sort sort);
	
	@Query(value = "{'matched': 'false'}")
	List<CurveOrder> findUnMatched(Sort sort);
}
