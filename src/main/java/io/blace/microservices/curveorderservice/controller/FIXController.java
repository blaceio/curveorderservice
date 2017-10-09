package io.blace.microservices.curveorderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import io.blace.microservices.curveorderservice.http.request.OrderRequest;
import io.blace.microservices.curveorderservice.mongo.fixexec.FIXExecutionReport;
import io.blace.microservices.curveorderservice.mongo.fixexec.FIXExecutionReportRepository;

@Controller
public class FIXController {
	
    @Autowired
    private FIXExecutionReportRepository fixrepo;
    
    public List<FIXExecutionReport> getrequested(OrderRequest request) {
    	return fixrepo.findAll(new Sort(Sort.Direction.DESC, "tradedate"));
    }
    
}

