package io.blace.microservices.curveorderservice.mongo.curveorder;

public class PL {

	private double plnative;
	private String plccy;
	private double usdpl;
	private double usdnotional;
	private double fx;
	private double costs;
	private double net;
	
	public double getPlnative() {
		return plnative;
	}
	public void setPlnative(double plnative) {
		this.plnative = plnative;
	}
	public double getUsdpl() {
		return usdpl;
	}
	public void setUsdpl(double usdpl) {
		this.usdpl = usdpl;
	}
	public double getFx() {
		return fx;
	}
	public void setFx(double fx) {
		this.fx = fx;
	}
	public String getPlccy() {
		return plccy;
	}
	public void setPlccy(String plccy) {
		this.plccy = plccy;
	}
	public double getCosts() {
		return costs;
	}
	public void setCosts(double costs) {
		this.costs = costs;
	}
	public double getNet() {
		return net;
	}
	public void setNet(double net) {
		this.net = net;
	}
	public double getUsdnotional() {
		return usdnotional;
	}
	public void setUsdnotional(double usdnotional) {
		this.usdnotional = usdnotional;
	}
	@Override
	public String toString() {
		return "PL [plnative=" + plnative + ", plccy=" + plccy + ", usdpl=" + usdpl + ", usdnotional=" + usdnotional
				+ ", fx=" + fx + ", costs=" + costs + ", net=" + net + "]";
	}

}
