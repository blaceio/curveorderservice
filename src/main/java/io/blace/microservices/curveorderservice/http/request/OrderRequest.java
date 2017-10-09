package io.blace.microservices.curveorderservice.http.request;

import java.util.Date;

public class OrderRequest {
	private String client;
	private Date startdate;
	private Date enddate;
	
	public OrderRequest() {
		this.client = "";
		this.startdate = new Date();
		this.enddate = new Date();
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	@Override
	public String toString() {
		return "OrderRequest [client=" + client + ", startdate=" + startdate + ", enddate=" + enddate + "]";
	}
	
}
