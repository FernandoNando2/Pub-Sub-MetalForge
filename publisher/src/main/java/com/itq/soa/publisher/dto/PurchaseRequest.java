package com.itq.soa.publisher.dto;

public class PurchaseRequest {
	private String provider;
	private String steelQuality;
	private int tons;
	private float price;
	private boolean urgent;
	
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getSteelQuality() {
		return steelQuality;
	}
	public void setSteelQuality(String steelQuality) {
		this.steelQuality = steelQuality;
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
