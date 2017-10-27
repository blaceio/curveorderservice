package io.blace.microservices.curveorderservice.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import io.blace.microservices.curveorderservice.controller.FIXController;
import io.blace.microservices.curveorderservice.http.request.OrderRequest;
import io.blace.microservices.curveorderservice.integration.gateway.OrderGateway;
import io.blace.microservices.curveorderservice.mongo.curveorder.OrderSummary;

@RestController
public class OrderRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FIXController fixcontroller;
	
	@Autowired
	private OrderGateway ordergateway;
	
    @CrossOrigin
    @PostMapping("/orderreports")
    public ResponseEntity<OrderSummary> orderreports(@RequestBody OrderRequest request) {
    		logger.info("orderreports request received: " + request);
    		Message<OrderRequest> message = MessageBuilder.withPayload(request).build();
    		OrderSummary ordersummary = ordergateway.send(message);
    		
    		return new ResponseEntity<OrderSummary>(ordersummary, new HttpHeaders(), HttpStatus.OK);
    }
    
}

