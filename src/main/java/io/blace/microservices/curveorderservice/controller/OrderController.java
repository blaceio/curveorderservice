package io.blace.microservices.curveorderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import io.blace.microservices.curveorderservice.http.request.OrderRequest;
import io.blace.microservices.curveorderservice.mongo.curveorder.CurveOrder;
import io.blace.microservices.curveorderservice.mongo.curveorder.CurveOrderRepository;

@Controller
public class OrderController {
	
    @Autowired
    private CurveOrderRepository curveorderrepo;
    
    public List<CurveOrder> getrequested(OrderRequest request) {
    		
    		Sort sort = new Sort(Sort.Direction.DESC, "tradedate");
    		
    		if( request.isTodays()) {
    			return curveorderrepo.findTodays(request.getStartdate(), request.getEnddate(), sort);
    		}
    		
    		if( !request.getClient().equals("")) {
    			return curveorderrepo.findByClient(request.getClient(), request.getStartdate(), request.getEnddate(), request.isMatched(), sort);
    		}

    		return curveorderrepo.findByMatched(request.getStartdate(), request.getEnddate(), request.isMatched(), sort);
    
    }
    
    public List<CurveOrder> unmatched() {
    		return curveorderrepo.findUnMatched(new Sort(Sort.Direction.DESC, "tradedate"));
    }
    
}
