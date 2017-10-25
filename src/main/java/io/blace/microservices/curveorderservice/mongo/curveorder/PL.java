package io.blace.microservices.curveorderservice.mongo.curveorder;

public class PL {

	private double plnative;
	private String plccy;
	private double usdpl;
	private double fx;
	
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
	@Override
	public String toString() {
		return "PL [plnative=" + plnative + ", plccy=" + plccy + ", usdpl=" + usdpl + ", fx=" + fx + "]";
	}
	
}
