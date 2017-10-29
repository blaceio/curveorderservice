package io.blace.microservices.curveorderservice.http.request;

import java.util.Date;

public class OrderRequest {
	private String client;
	private Date startdate;
	private Date enddate;
	private boolean matched;
	
	public OrderRequest() {
		this.client = "";
		this.startdate = new Date();
		this.enddate = new Date();
		this.matched = true;
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
	public boolean isMatched() {
		return matched;
	}
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	@Override
	public String toString() {
		return "OrderRequest [client=" + client + ", startdate=" + startdate + ", enddate=" + enddate + ", matched="
				+ matched + "]";
	}

}
