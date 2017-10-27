package io.blace.microservices.curveorderservice.integration.gateway;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import io.blace.microservices.curveorderservice.http.request.OrderRequest;
import io.blace.microservices.curveorderservice.mongo.curveorder.OrderSummary;

@Component
public interface OrderGateway {  
	 public OrderSummary send(Message<OrderRequest> message);  
} 