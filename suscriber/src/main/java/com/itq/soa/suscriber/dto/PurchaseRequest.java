package com.itq.soa.suscriber.dto;

public class PurchaseRequest {
	private String provider;
	private String stealQuality;
	private int tons;
	private float price;
	private boolean urgent;
	
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getStealQuality() {
		return stealQuality;
	}
	public void setStealQuality(String stealQuality) {
		this.stealQuality = stealQuality;
	}
	public int getTons() {
		return tons;
	}
	public void setTons(int tons) {
		this.tons = tons;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isUrgent() {
		return urgent;
	}
	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
	
	
	

}
