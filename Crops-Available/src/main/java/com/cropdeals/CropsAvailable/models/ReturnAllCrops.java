package com.cropdeals.CropsAvailable.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReturnAllCrops {

	List<Crops> listOfCrops;

	public ReturnAllCrops(List<Crops> listOfCrops) {
		super();
		this.listOfCrops = listOfCrops;
	}

	public List<Crops> getListOfCrops() {
		return listOfCrops;
	}

	public void setListOfCrops(List<Crops> listOfCrops) {
		this.listOfCrops = listOfCrops;
	}
 	
}
