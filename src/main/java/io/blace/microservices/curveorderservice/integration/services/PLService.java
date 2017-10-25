package io.blace.microservices.curveorderservice.integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.blace.microservices.curveorderservice.mongo.curveorder.CurveOrder;
import io.blace.microservices.curveorderservice.mongo.curveorder.PL;
import io.blace.microservices.curveorderservice.mongo.fxspot.FxSpot;
import io.blace.microservices.curveorderservice.mongo.fxspot.FxSpotRepository;

public class PLService {

	@Autowired
	private FxSpotRepository fxspotrepo;
	
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
				}
				if( baseccy.equals("USD")) {
					FxSpot fx = fxspotrepo.findByRisk(riskccy);
					order.getPl().setFx(1 / fx.getRate());
					order.getPl().setUsdpl(plnative * order.getPl().getFx());
				}
				if( !baseccy.equals("USD") && !riskccy.equals("USD")) {
					FxSpot fx = fxspotrepo.findByRiskOrBase(riskccy);
					
					if( riskccy.equals(fx.getBase())) {
						order.getPl().setFx(fx.getRate());
					} else {
						order.getPl().setFx(1 / fx.getRate());
					}
					order.getPl().setUsdpl(plnative * order.getPl().getFx());
				}
			} else {
				order.getPl().setFx(0.);
				order.getPl().setUsdpl(0.);
			}
			
		}
		
		return orders;
	}

}
