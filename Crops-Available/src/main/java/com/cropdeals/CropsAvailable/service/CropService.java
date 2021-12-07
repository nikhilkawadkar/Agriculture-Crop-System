package com.cropdeals.CropsAvailable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeals.CropsAvailable.models.Crops;
import com.cropdeals.CropsAvailable.models.ReturnAllCrops;
import com.cropdeals.CropsAvailable.repository.CropRepo;

@Service
public class CropService {

	@Autowired
	private CropRepo repos;
	
	@Autowired
	private ReturnAllCrops returnAllCrops;
	
	public void addCrop(Crops crop) {
		repos.insert(crop);
	}
	
	public ReturnAllCrops showAllCrops() {
		returnAllCrops.setListOfCrops(repos.findAll());
		return returnAllCrops;
	}
	
	public ReturnAllCrops findMyCrop(String farmerId) { 
		returnAllCrops.setListOfCrops(repos.findAllByfarmerId(farmerId));
		return returnAllCrops;
	}

	public void buyCrop(Crops crop, String id) {
		crop.setId( id );
        repos.save(crop);
	}

	public void updateCrop(Crops crop, String id) {
		crop.setId( id );
        repos.save(crop);
	}

	public void deleteCrop(String id) {
		repos.deleteById(id);
	}
	
}
