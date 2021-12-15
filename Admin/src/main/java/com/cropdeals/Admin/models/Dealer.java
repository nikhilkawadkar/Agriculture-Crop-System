package com.cropdeals.Admin.models;

import java.util.List;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Service
public class Dealer {
 
	private String id;
	private String dealerName;
	private String dealerPassword;
	private List<String> subscribedCrops;
	
	public Dealer(){}

	public Dealer(String id, String dealerName, String dealerPassword, List<String> subscribedCrops) {
		super();
		this.id = id;
		this.dealerName = dealerName;
		this.dealerPassword = dealerPassword;
		this.subscribedCrops = subscribedCrops;
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

	public String getDealerPassword() {
		return dealerPassword;
	}

	public void setDealerPassword(String dealerPassword) {
		this.dealerPassword = dealerPassword;
	}

	public List<String> getSubscribedCrops() {
		return subscribedCrops;
	}

	public void setSubscribedCrops(List<String> subscribedCrops) {
		this.subscribedCrops = subscribedCrops;
	}

}
