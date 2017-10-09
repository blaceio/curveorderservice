package io.blace.microservices.curveorderservice.http;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.blace.microservices.curveorderservice.controller.FIXController;
import io.blace.microservices.curveorderservice.controller.OrderController;
import io.blace.microservices.curveorderservice.http.request.OrderRequest;
import io.blace.microservices.curveorderservice.mongo.curveorder.CurveOrder;
import io.blace.microservices.curveorderservice.mongo.fixexec.FIXExecutionReport;

@RestController
public class OrderRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderController ordercontroller;
	
	@Autowired
	FIXController fixcontroller;
	
    @CrossOrigin
    @PostMapping("/fixreports")
    public ResponseEntity<List<FIXExecutionReport>> fixreports(@RequestBody OrderRequest request) {
    		logger.info("fixreports request received: " + request);
    		return new ResponseEntity<List<FIXExecutionReport>>(fixcontroller.getrequested(request), new HttpHeaders(), HttpStatus.OK);
    }
    
    @CrossOrigin
    @PostMapping("/orderreports")
    public ResponseEntity<List<CurveOrder>> orderreports(@RequestBody OrderRequest request) {
    		logger.info("orderreports request received: " + request);
    		return new ResponseEntity<List<CurveOrder>>(ordercontroller.getrequested(request), new HttpHeaders(), HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/unmatchedorders")
    public ResponseEntity<List<CurveOrder>> getAllClients() {
    	logger.info("getclients request received.");
        return new ResponseEntity<List<CurveOrder>>(ordercontroller.unmatched(), new HttpHeaders(), HttpStatus.OK);
    }
    
}

