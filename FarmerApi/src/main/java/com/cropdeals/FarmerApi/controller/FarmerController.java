package com.cropdeals.FarmerApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropdeals.FarmerApi.models.FarmerProfile;
import com.cropdeals.FarmerApi.Services.ProfileServices;
import com.cropdeals.FarmerApi.models.Crops;

@RestController
@RequestMapping("/farmer")
public class FarmerController {

	@Autowired
	private ProfileServices profileServices;
 
	@PostMapping("/addfarmer")
	public void addFarmer(@RequestBody FarmerProfile farmerProfile) {
		profileServices.addFarmer(farmerProfile);
	}

	@PostMapping("/auth")
	private String authfarmer(@RequestBody FarmerProfile farmerProfile) {
		 return profileServices.authFarmer(farmerProfile);
	}

	@GetMapping("/allfarmers")
	public List<FarmerProfile> showAllFarmers() {
		return profileServices.showAllFarmer();
	}

	@GetMapping("/findfarmer/{farmerName}")
	public FarmerProfile findFarmer(@PathVariable String farmerName) {
		return profileServices.findFarmerByName(farmerName);
	}

	@PutMapping("/rating/{id}")
	public void giveRating(@RequestBody FarmerProfile farmerProfile, @PathVariable String id) {
		profileServices.giveRating(farmerProfile, id);
	}

	@PutMapping("/updatefarmer/{id}")
	public String updateFarmer(@RequestBody FarmerProfile farmerProfile, @PathVariable String id) {
		return profileServices.updateFarmer(farmerProfile, id);
	}

	@GetMapping("/deletefarmer/{id}")
	public String deleteFarmer(@PathVariable String id) {
		return profileServices.deleteFarmer(id);
	}

	// crop CRUD operations

	@PostMapping("/addcrop")
	public void addCrop(@RequestBody Crops crop) {
		profileServices.addCrop(crop);
	}

	@GetMapping("/allmycrops/{farmerId}")
	public List<Crops> getMyCrops(@PathVariable String farmerId) {
		return profileServices.getMyCrops(farmerId);
	}

	@GetMapping("/allcrops")
	public List<Crops> showAllCrops() {
		return profileServices.showAllCrops();
	}

	@GetMapping("/deletecrop/{id}")
	public String deleteCrop(@PathVariable String id) {
		return profileServices.deleteCrop(id);
	}
}
