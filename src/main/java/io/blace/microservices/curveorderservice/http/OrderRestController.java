package io.blace.microservices.curveorderservice.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import io.blace.microservices.curveorderservice.http.request.OrderRequest;
import io.blace.microservices.curveorderservice.http.request.UpdateRequest;
import io.blace.microservices.curveorderservice.integration.gateway.OrderGateway;
import io.blace.microservices.curveorderservice.mongo.curveorder.CurveOrder;
import io.blace.microservices.curveorderservice.mongo.curveorder.OrderSummary;

@RestController
public class OrderRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderGateway ordergateway;
	
	@Autowired
	private MongoOperations operations;
	
    @CrossOrigin
    @PostMapping("/orderreports")
    public ResponseEntity<OrderSummary> orderreports(@RequestBody OrderRequest request) {
    		logger.info("orderreports request received: " + request);
    		Message<OrderRequest> message = MessageBuilder.withPayload(request).build();
    		OrderSummary ordersummary = ordergateway.send(message);
    		
    		return new ResponseEntity<OrderSummary>(ordersummary, new HttpHeaders(), HttpStatus.OK);
    }
    
    @CrossOrigin
    @PostMapping("/updatecurveprice")
    public ResponseEntity<String> updatecurveprice(@RequestBody UpdateRequest request) {
    		logger.info("updatecurveprice request received: " + request);
    		
    		Query query = new Query();
    		query.addCriteria(Criteria.where("orderid").is(request.getOrderid()));
    		query.addCriteria(Criteria.where("tradedate").is(request.getTradedate()));
    		query.fields().include("orderid");
    		query.fields().include("tradedate");

    		Update update = new Update();
    		update.set("clientleg.curveprice", request.getCurveprice());

    		operations.updateFirst(query, update, CurveOrder.class);
    		
    		return new ResponseEntity<String>("updated", new HttpHeaders(), HttpStatus.OK);
    }
    
}

