package com.cropdeals.Admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropdeals.Admin.models.Crops;
import com.cropdeals.Admin.models.FarmerProfile;
import com.cropdeals.Admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/addfarmer")
	public void addFarmer(@RequestBody FarmerProfile farmerProfile) {
		adminService.addFarmer(farmerProfile);
	}

	@GetMapping("/allfarmers")
	public String showAllFarmers() {
		return adminService.showAllFarmer();
	}
//
//	@GetMapping("/findfarmer/{farmerName}")
//	public FarmerProfile findFarmer(@PathVariable String farmerName) {
//		return adminService.findFarmerByName(farmerName);
//	}
//
//	@PutMapping("/rating/{id}")
//	public void giveRating(@RequestBody FarmerProfile farmerProfile, @PathVariable String id) {
//		adminService.giveRating(farmerProfile, id);
//	}
//
//	@PutMapping("/updatefarmer/{id}")
//	public String updateFarmer(@RequestBody FarmerProfile farmerProfile, @PathVariable String id) {
//		return adminService.updateFarmer(farmerProfile, id);
//	}
//
//	@GetMapping("/deletefarmer/{id}")
//	public String deleteFarmer(@PathVariable String id) {
//		return adminService.deleteFarmer(id);
//	}

	// crop CRUD operations

	@PostMapping("/addcrop")
	public void addCrop(@RequestBody Crops crop) {
		adminService.addCrop(crop);
	}

	@GetMapping("/allmycrops/{farmerId}")
	public List<Crops> getMyCrops(@PathVariable String farmerId) {
		return adminService.getMyCrops(farmerId);
	}

	@GetMapping("/allcrops")
	public List<Crops> showAllCrops() {
		return adminService.showAllCrops();
	}

	@GetMapping("/deletecrop/{id}")
	public String deleteCrop(@PathVariable String id) {
		return adminService.deleteCrop(id);
	}
	
}
