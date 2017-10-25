package io.blace.microservices.curveorderservice.mongo.curveorder;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import io.blace.microservices.curveorderservice.mongo.fixexec.FIXExecutionReport;

public class CurveOrder {

	@Id
	public String id;
	
	private String orderid;
	private String pair;
	private String ccy;
	private boolean matched;
	private Date tradedate;
	private String client;
	private double quantity;
	private Date valuedate;
	private String trader;
	private String type;
	private Order clientleg;
	private Order execleg;
	private PL pl;
	private List<FIXExecutionReport> fixexecutions;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public boolean isMatched() {
		return matched;
	}
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	public Date getTradedate() {
		return tradedate;
	}
	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public Date getValuedate() {
		return valuedate;
	}
	public void setValuedate(Date valuedate) {
		this.valuedate = valuedate;
	}
	public String getTrader() {
		return trader;
	}
	public void setTrader(String trader) {
		this.trader = trader;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Order getClientleg() {
		return clientleg;
	}
	public void setClientleg(Order clientleg) {
		this.clientleg = clientleg;
	}
	public Order getExecleg() {
		return execleg;
	}
	public void setExecleg(Order execleg) {
		this.execleg = execleg;
	}
	public PL getPl() {
		return pl;
	}
	public void setPl(PL pl) {
		this.pl = pl;
	}
	public List<FIXExecutionReport> getFixexecutions() {
		return fixexecutions;
	}
	public void setFixexecutions(List<FIXExecutionReport> fixexecutions) {
		this.fixexecutions = fixexecutions;
	}
	@Override
	public String toString() {
		return "CurveOrder [id=" + id + ", orderid=" + orderid + ", pair=" + pair + ", ccy=" + ccy + ", matched="
				+ matched + ", tradedate=" + tradedate + ", client=" + client + ", quantity=" + quantity
				+ ", valuedate=" + valuedate + ", trader=" + trader + ", type=" + type + ", clientleg=" + clientleg
				+ ", execleg=" + execleg + ", pl=" + pl + ", fixexecutions=" + fixexecutions + "]";
	}
	
}
