package com.cropdeals.Admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cropdeals.Admin.models.Crops;
import com.cropdeals.Admin.models.FarmerProfile;
import com.cropdeals.Admin.models.ReturnAllCrops;


@Service
public class AdminService {
	
	@Autowired
	private RestTemplate restTemplate;
	

	public void addFarmer(FarmerProfile farmerProfile) {
		restTemplate.postForEntity("http://farmerApi/farmer/addfarmer",farmerProfile,FarmerProfile.class);
	}

	public String showAllFarmer() {
		return  restTemplate.getForObject("http://farmerApi/farmer/allfarmers", String.class);
	}

//	public FarmerProfile findFarmerByName(String farmerName) {
//		return profileRepo.findByfName(farmerName);
//	}
//
//	public void giveRating(FarmerProfile farmerProfile, String id) {
//		farmerProfile.setId( id );  
//        Integer rating= farmerProfile.getAllRatings().stream().mapToInt(Integer::intValue).sum()/farmerProfile.getAllRatings().size();
//        farmerProfile.setRating(rating);
//        profileRepo.save(farmerProfile);
//	}
//
//	public String updateFarmer(FarmerProfile farmerProfile, String id) {
//		farmerProfile.setId( id );  
//        profileRepo.save(farmerProfile);
//        return "Updated Successfully";
//	}
//
//	public String deleteFarmer(String id) {
//		profileRepo.deleteById( id );
//		return "Deleted Successfully";
//	}

	public void addCrop(Crops crop) {
		restTemplate.postForEntity("http://crop-avalilable/crops/addcrop",crop,Crops.class);
	}

	public List<Crops> getMyCrops(String farmerId) {
		ReturnAllCrops allCrops = restTemplate.getForObject("http://crop-avalilable/crops/findmycrop/"+farmerId, ReturnAllCrops.class);
		return allCrops.getListOfCrops();
	}

	public List<Crops> showAllCrops() {
		ReturnAllCrops allCrops = restTemplate.getForObject("http://crop-avalilable/crops/allcrops", ReturnAllCrops.class);
		return allCrops.getListOfCrops();
	}

	public String deleteCrop(String id) {
		return restTemplate.getForObject("http://crop-avalilable/crops/deletecrop/"+id, String.class);
	}

}
