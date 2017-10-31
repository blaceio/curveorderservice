package io.blace.microservices.curveorderservice.integration.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.blace.microservices.curveorderservice.http.request.FxSpotRequest;
import io.blace.microservices.curveorderservice.mongo.curveorder.CurveOrder;
import io.blace.microservices.curveorderservice.mongo.curveorder.OrderSummary;
import io.blace.microservices.curveorderservice.mongo.curveorder.PL;
import io.blace.microservices.curveorderservice.mongo.curveorder.Summary;
import io.blace.microservices.curveorderservice.mongo.fxspot.FxSpot;

@Service
public class PLService {
	
	@Value("${fxspotservice.dateriskurl}")
	private String dateriskurl;
	
	@Value("${fxspotservice.dateriskorbaseurl}")
	private String dateriskorbaseurl;
	
	private final RestTemplate resttemplate;
	
	public PLService(RestTemplateBuilder resttemplatebuilder) {
		this.resttemplate = resttemplatebuilder.build();
	}
	
	public List<CurveOrder> calcnative(List<CurveOrder> orders) {

		for( CurveOrder order : orders) {

			PL pl = new PL();
			
			if( order.isMatched() ) {
				
				double plnative = 0.;

				if( order.getExecleg().isBuy()) {
					plnative = order.getClientleg().getPrice() - order.getExecleg().getPrice();
				} else {
					plnative = order.getExecleg().getPrice() - order.getClientleg().getPrice();
				}
				pl.setPlnative(plnative);
				pl.setPlccy(order.getPair().substring(order.getPair().length() - 3));
			} else {
				pl.setPlnative(0.);
				pl.setPlccy("");
			}
			
			order.setPl(pl);
		}

		return orders;
	}

	public List<CurveOrder> calcusd(List<CurveOrder> orders) {

		for( CurveOrder order : orders) {

			if( order.isMatched() ) {
				
				double plnative = order.getPl().getPlnative();
				String baseccy = order.getPair().substring(0, 3);
				String riskccy = order.getPair().substring(order.getPair().length() - 3);
				
				if( riskccy.equals("USD")) {
					order.getPl().setFx(1.);
					order.getPl().setUsdpl(plnative);
					order.getPl().setUsdnotional(order.getQuantity());
				}
				if( baseccy.equals("USD")) {
					
					FxSpot fx = resttemplate.postForObject(dateriskurl, new FxSpotRequest(order.getTradedate(), "", riskccy), FxSpot.class);
					order.getPl().setReffx(fx);
					order.getPl().setFx(1 / fx.getRate());
					order.getPl().setUsdpl(plnative * order.getPl().getFx());
					order.getPl().setUsdnotional(order.getQuantity() * order.getPl().getFx());
				}
				if( !baseccy.equals("USD") && !riskccy.equals("USD")) {
					FxSpot fx = resttemplate.postForObject(dateriskorbaseurl, new FxSpotRequest(order.getTradedate(), "", riskccy), FxSpot.class);
					order.getPl().setReffx(fx);
					if( riskccy.equals(fx.getBase())) {
						order.getPl().setFx(fx.getRate());
					} else {
						order.getPl().setFx(1 / fx.getRate());
					}
					order.getPl().setUsdpl(plnative * order.getPl().getFx());
					order.getPl().setUsdnotional(order.getQuantity() * order.getPl().getFx());
				}
			} else {
				order.getPl().setFx(0.);
				order.getPl().setUsdpl(0.);
				order.getPl().setUsdnotional(0.);
			}
			
		}
		
		return orders;
	}

	public List<CurveOrder> calcfees(List<CurveOrder> orders) {
		
		for( CurveOrder order : orders ) {
			double notional = order.getQuantity();
			double rbs = (notional/1000000) * 6;
			double flex = (notional/1000000) * 3;
			order.getPl().setCosts(rbs + flex);
		}
		
		return orders;
	}
	
	public List<CurveOrder> calcnet(List<CurveOrder> orders) {
		
		for( CurveOrder order : orders ) {
			if( order.isMatched() ) {
				order.getPl().setNet((order.getPl().getUsdpl() * order.getQuantity()) - order.getPl().getCosts());
			}
		}
		
		return orders;
	}
	
	public OrderSummary calcsummary(List<CurveOrder> orders) {
		
		double volume = 0.;
		double gross = 0.;
		double fees = 0.;
		double net = 0.;
		Map<String, Summary> summaries = new HashMap<String, Summary>();
		Map<String, FxSpot> usedspots = new HashMap<String, FxSpot>();
		
		for( CurveOrder order : orders ) {
	
			if( order.isMatched() ) {
				
				if( !(order.getPl().getReffx() == null) )
						usedspots.put(order.getPl().getReffx().getId(), order.getPl().getReffx());
				
				volume += order.getPl().getUsdnotional();
				gross += order.getPl().getUsdpl() * order.getQuantity();
				fees += order.getPl().getCosts();
				net += order.getPl().getNet();
				if( summaries.containsKey(order.getClient())) {
					double _volume = summaries.get(order.getClient()).getVolume() + order.getPl().getUsdnotional();
					double _profit = summaries.get(order.getClient()).getProfit() + order.getPl().getNet();
					summaries.get(order.getClient()).setProfit(_profit);
					summaries.get(order.getClient()).setVolume(_volume);
				} else {
					Summary summary = new Summary();
					summary.setClient(order.getClient());
					summary.setVolume(order.getPl().getUsdnotional());
					summary.setProfit(order.getPl().getNet());
					summaries.put(order.getClient(), summary);
				}
			}
		}
		
		List<Summary> _summaries = new ArrayList<Summary>();
		for (Map.Entry<String, Summary> entry : summaries.entrySet()) {
			entry.getValue().setProfitpercent((entry.getValue().getProfit()/net)*100);
			entry.getValue().setVolumepercent((entry.getValue().getVolume()/volume)*100);
			_summaries.add(entry.getValue());
		}
		
		OrderSummary ordersummary = new OrderSummary();
		ordersummary.setVolume(volume);
		ordersummary.setGross(gross);
		ordersummary.setFees(fees);
		ordersummary.setNet(net);
		ordersummary.setOrders(orders);
		ordersummary.setClientsummary(_summaries);
		ordersummary.setUsedspots(usedspots.values());
		
		return ordersummary;
	}
	
}
