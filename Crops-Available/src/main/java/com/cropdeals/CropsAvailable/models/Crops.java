package com.cropdeals.CropsAvailable.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Crops {
	@Id
	private String id;
	private String farmerId;
	private String cropName;
	private String address;
	private int qty;
	private List<String> dealersId = new ArrayList<String>();
  
	 public Crops() {}

	public Crops(String id, String farmerId, String cropName, String address, int qty, List<String> dealersId) {
		super();
		this.id = id;
		this.farmerId = farmerId;
		this.cropName = cropName;
		this.address = address;
		this.qty = qty;
		this.dealersId = dealersId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public List<String> getDealersId() {
		return dealersId;
	}

	public void setDealersId(List<String> dealersId) {
		this.dealersId = dealersId;
	}
	 
	 
	 

}
