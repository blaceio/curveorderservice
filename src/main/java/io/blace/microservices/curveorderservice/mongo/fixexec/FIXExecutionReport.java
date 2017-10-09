package io.blace.microservices.curveorderservice.mongo.fixexec;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class FIXExecutionReport {

	@Id
	public String id;

	private String account;
	private String symbol;
	private double avgPx;
	private String clOrdID;
	private double cumQty;
	private String currency;
	private String execID;
	private double lastPx;
	private double lastQty;
	private String orderID;
	private double orderQty;
	private String ordStatus;
	private String ordType;
	private double price;
	private String side;
	private String timeInForce;
	private Date transactTime;
	private String settlDate;
	private String listID;
	private String tradeDate;
	private String execType;
	private double leavesQty;
	private Date effectiveTime;
	private int noContraBrokers;
	private String secondaryExecID;
	private String partyID;
	private String contraBroker;
	private String sourceSystem;
	private String senderCompID;
	private String targetCompID;
	private String deliverToCompID;
	private String deliverToSubID;
	private String senderLocationID;
	private String sendingTime;
	private String lastCapacity;
	private String securityType;
	private double flexMarketPrice;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getAvgPx() {
		return avgPx;
	}
	public void setAvgPx(double avgPx) {
		this.avgPx = avgPx;
	}
	public String getClOrdID() {
		return clOrdID;
	}
	public void setClOrdID(String clOrdID) {
		this.clOrdID = clOrdID;
	}
	public double getCumQty() {
		return cumQty;
	}
	public void setCumQty(double cumQty) {
		this.cumQty = cumQty;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getExecID() {
		return execID;
	}
	public void setExecID(String execID) {
		this.execID = execID;
	}
	public double getLastPx() {
		return lastPx;
	}
	public void setLastPx(double lastPx) {
		this.lastPx = lastPx;
	}
	public double getLastQty() {
		return lastQty;
	}
	public void setLastQty(double lastQty) {
		this.lastQty = lastQty;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public double getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(double orderQty) {
		this.orderQty = orderQty;
	}
	public String getOrdStatus() {
		return ordStatus;
	}
	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}
	public String getOrdType() {
		return ordType;
	}
	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getTimeInForce() {
		return timeInForce;
	}
	public void setTimeInForce(String timeInForce) {
		this.timeInForce = timeInForce;
	}
	public Date getTransactTime() {
		return transactTime;
	}
	public void setTransactTime(Date transactTime) {
		this.transactTime = transactTime;
	}
	public String getSettlDate() {
		return settlDate;
	}
	public void setSettlDate(String settlDate) {
		this.settlDate = settlDate;
	}
	public String getListID() {
		return listID;
	}
	public void setListID(String listID) {
		this.listID = listID;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getExecType() {
		return execType;
	}
	public void setExecType(String execType) {
		this.execType = execType;
	}
	public double getLeavesQty() {
		return leavesQty;
	}
	public void setLeavesQty(double leavesQty) {
		this.leavesQty = leavesQty;
	}
	public Date getEffectiveTime() {
		return effectiveTime;
	}
	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	public int getNoContraBrokers() {
		return noContraBrokers;
	}
	public void setNoContraBrokers(int noContraBrokers) {
		this.noContraBrokers = noContraBrokers;
	}
	public String getSecondaryExecID() {
		return secondaryExecID;
	}
	public void setSecondaryExecID(String secondaryExecID) {
		this.secondaryExecID = secondaryExecID;
	}
	public String getPartyID() {
		return partyID;
	}
	public void setPartyID(String partyID) {
		this.partyID = partyID;
	}
	public String getContraBroker() {
		return contraBroker;
	}
	public void setContraBroker(String contraBroker) {
		this.contraBroker = contraBroker;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getSenderCompID() {
		return senderCompID;
	}
	public void setSenderCompID(String senderCompID) {
		this.senderCompID = senderCompID;
	}
	public String getTargetCompID() {
		return targetCompID;
	}
	public void setTargetCompID(String targetCompID) {
		this.targetCompID = targetCompID;
	}
	public String getDeliverToCompID() {
		return deliverToCompID;
	}
	public void setDeliverToCompID(String deliverToCompID) {
		this.deliverToCompID = deliverToCompID;
	}
	public String getDeliverToSubID() {
		return deliverToSubID;
	}
	public void setDeliverToSubID(String deliverToSubID) {
		this.deliverToSubID = deliverToSubID;
	}
	public String getSenderLocationID() {
		return senderLocationID;
	}
	public void setSenderLocationID(String senderLocationID) {
		this.senderLocationID = senderLocationID;
	}
	public String getSendingTime() {
		return sendingTime;
	}
	public void setSendingTime(String sendingTime) {
		this.sendingTime = sendingTime;
	}
	public String getLastCapacity() {
		return lastCapacity;
	}
	public void setLastCapacity(String lastCapacity) {
		this.lastCapacity = lastCapacity;
	}
	public String getSecurityType() {
		return securityType;
	}
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	public double getFlexMarketPrice() {
		return flexMarketPrice;
	}
	public void setFlexMarketPrice(double flexMarketPrice) {
		this.flexMarketPrice = flexMarketPrice;
	}
	@Override
	public String toString() {
		return "FIXExecutionReport [id=" + id + ", account=" + account + ", symbol=" + symbol + ", avgPx=" + avgPx
				+ ", clOrdID=" + clOrdID + ", cumQty=" + cumQty + ", currency=" + currency + ", execID=" + execID
				+ ", lastPx=" + lastPx + ", lastQty=" + lastQty + ", orderID=" + orderID + ", orderQty=" + orderQty
				+ ", ordStatus=" + ordStatus + ", ordType=" + ordType + ", price=" + price + ", side=" + side
				+ ", timeInForce=" + timeInForce + ", transactTime=" + transactTime + ", settlDate=" + settlDate
				+ ", listID=" + listID + ", tradeDate=" + tradeDate + ", execType=" + execType + ", leavesQty="
				+ leavesQty + ", effectiveTime=" + effectiveTime + ", noContraBrokers=" + noContraBrokers
				+ ", secondaryExecID=" + secondaryExecID + ", partyID=" + partyID + ", contraBroker=" + contraBroker
				+ ", sourceSystem=" + sourceSystem + ", senderCompID=" + senderCompID + ", targetCompID=" + targetCompID
				+ ", deliverToCompID=" + deliverToCompID + ", deliverToSubID=" + deliverToSubID + ", senderLocationID="
				+ senderLocationID + ", sendingTime=" + sendingTime + ", lastCapacity=" + lastCapacity
				+ ", securityType=" + securityType + ", flexMarketPrice=" + flexMarketPrice + "]";
	}
	
}
