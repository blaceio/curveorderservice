package io.blace.microservices.curveorderservice.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import io.blace.microservices.curveorderservice.http.request.OrderRequest;
import io.blace.microservices.curveorderservice.mongo.curveorder.CurveOrder;
import io.blace.microservices.curveorderservice.mongo.curveorder.CurveOrderRepository;

@Service
public class OrderService {

	@Autowired
	private CurveOrderRepository curveorderrepo;

	public List<CurveOrder> getorders(Message<OrderRequest> request) {
		OrderRequest _request = request.getPayload();

		Sort sort = new Sort(Sort.Direction.DESC, "tradedate");

		if( !_request.getClient().equals("")) {
			return curveorderrepo.findByClientAndByMatched(_request.getClient(), _request.getStartdate(), _request.getEnddate(), _request.isMatched(), sort);
		}

		return curveorderrepo.findByMatched(_request.getStartdate(), _request.getEnddate(), _request.isMatched(), sort);

	}



}
