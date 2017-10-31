package io.blace.microservices.curveorderservice.mongo.curveorder;

import java.util.Collection;
import java.util.List;

import io.blace.microservices.curveorderservice.mongo.fxspot.FxSpot;

public class OrderSummary {

	private List<CurveOrder> orders;
	private double volume;
	private double gross;
	private double fees;
	private double net;
	private List<Summary> clientsummary;
	private Collection<FxSpot> usedspots;

	public List<CurveOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<CurveOrder> orders) {
		this.orders = orders;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getGross() {
		return gross;
	}
	public void setGross(double gross) {
		this.gross = gross;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public double getNet() {
		return net;
	}
	public void setNet(double net) {
		this.net = net;
	}
	public List<Summary> getClientsummary() {
		return clientsummary;
	}
	public void setClientsummary(List<Summary> clientsummary) {
		this.clientsummary = clientsummary;
	}
	public Collection<FxSpot> getUsedspots() {
		return usedspots;
	}
	public void setUsedspots(Collection<FxSpot> usedspots) {
		this.usedspots = usedspots;
	}
	@Override
	public String toString() {
		return "OrderSummary [orders=" + orders + ", volume=" + volume + ", gross=" + gross + ", fees=" + fees
				+ ", net=" + net + ", clientsummary=" + clientsummary + ", usedspots=" + usedspots + "]";
	}
	
}
