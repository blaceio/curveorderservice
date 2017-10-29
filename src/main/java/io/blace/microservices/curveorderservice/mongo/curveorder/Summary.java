package io.blace.microservices.curveorderservice.mongo.curveorder;

public class Summary {
	private String client;
	private double volumepercent;
	private double profitpercent;
	private double volume;
	private double profit;
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public double getVolumepercent() {
		return volumepercent;
	}
	public void setVolumepercent(double volumepercent) {
		this.volumepercent = volumepercent;
	}
	public double getProfitpercent() {
		return profitpercent;
	}
	public void setProfitpercent(double profitpercent) {
		this.profitpercent = profitpercent;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "Summary [client=" + client + ", volumepercent=" + volumepercent + ", profitpercent=" + profitpercent
				+ ", volume=" + volume + ", profit=" + profit + "]";
	}
	
}
