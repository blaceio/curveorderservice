package io.blace.microservices.curveorderservice.mongo.fxspot;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FxSpotRepository extends MongoRepository<FxSpot, String> {
	
	FxSpot findByRisk(String risk);
	FxSpot findByRiskOrBase(String ccy);
}
