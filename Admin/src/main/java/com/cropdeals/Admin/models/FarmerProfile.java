package com.cropdeals.Admin.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Service
public class FarmerProfile {
 
	private String id;
	private int farmerId;
	private String fName;
	private String fPassword;
	private String fAccountNo;
	private int rating;
	private List<Integer> allRatings;
	
	public FarmerProfile() {}

	public FarmerProfile(String id, int farmerId, String fName, String fPassword, String fAccountNo, int rating,
			List<Integer> allRatings) {
		super();
		this.id = id;
		this.farmerId = farmerId;
		this.fName = fName;
		this.fPassword = fPassword;
		this.fAccountNo = fAccountNo;
		this.rating = rating;
		this.allRatings = allRatings;
	}
	
	public int getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(int farmerID) {
		this.farmerId = farmerID;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfPassword() {
		return fPassword;
	}

	public void setfPassword(String fPassword) {
		this.fPassword = fPassword;
	}

	public String getfAccountNo() {
		return fAccountNo;
	}

	public void setfAccountNo(String fAccountNo) {
		this.fAccountNo = fAccountNo;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Integer> getAllRatings() {
		return allRatings;
	}

	public void setAllRatings(List<Integer> allRatings) {
		this.allRatings = allRatings;
	}
	
}
