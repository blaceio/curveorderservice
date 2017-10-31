package io.blace.microservices.curveorderservice.http.request;

import java.util.Date;

public class UpdateRequest {
	private String orderid;
	private Date tradedate;
	private double curveprice;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Date getTradedate() {
		return tradedate;
	}
	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}
	public double getCurveprice() {
		return curveprice;
	}
	public void setCurveprice(double curveprice) {
		this.curveprice = curveprice;
	}
	@Override
	public String toString() {
		return "UpdateRequest [orderid=" + orderid + ", timestamp=" + tradedate + ", curveprice=" + curveprice + "]";
	}

}
