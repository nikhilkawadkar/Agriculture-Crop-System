package com.cropdeals.Admin.models;

import java.util.List;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dealer {

	@Id
	private String id;
	private String dealerName;
	private List<String> subscriberCrop;
	
	
	public Dealer(String id, String dealerName, List<String> subscriberCrop) {
		super();
		this.id = id;
		this.dealerName = dealerName;
		this.subscriberCrop = subscriberCrop;
	 
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public List<String> getSubscriberCrop() {
		return subscriberCrop;
	}
	public void setSubscriberCrop(List<String> subscriberCrop) {
		this.subscriberCrop = subscriberCrop;
	}
	
}
