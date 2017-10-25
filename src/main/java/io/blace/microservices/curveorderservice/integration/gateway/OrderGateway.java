package io.blace.microservices.curveorderservice.integration.gateway;

import java.util.List;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import io.blace.microservices.curveorderservice.http.request.OrderRequest;
import io.blace.microservices.curveorderservice.mongo.curveorder.CurveOrder;

@Component
public interface OrderGateway {  
	 public List<CurveOrder> send(Message<OrderRequest> message);  
} 