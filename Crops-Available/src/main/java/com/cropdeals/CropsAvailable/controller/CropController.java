package com.cropdeals.CropsAvailable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropdeals.CropsAvailable.models.Crops;
import com.cropdeals.CropsAvailable.models.ReturnAllCrops;
import com.cropdeals.CropsAvailable.service.CropService;

@RestController
@RequestMapping("/crops")
public class CropController {
 
	@Autowired
	private CropService cropService;
	
	@PostMapping("/addcrop")
	public void addCrops(@RequestBody Crops crop) {
		cropService.addCrop(crop);
	}
	
	@GetMapping("/allcrops")
	public ReturnAllCrops showAllCrps() {
		return cropService.showAllCrops();		
	}
 
	@GetMapping("/findmycrop/{farmerId}")
	public ReturnAllCrops findmycrop( @PathVariable String farmerId ){
		return cropService.findMyCrop(farmerId);
	}
	
	@PutMapping("/buycrop/{id}")
    public void buyCrop(@RequestBody Crops crop, @PathVariable("id") String id) {
		cropService.buyCrop(crop,id);
    }
	
	@PutMapping("/updatecrop/{id}")
    public String updateOrder(@RequestBody Crops crop, @PathVariable String id) {
		cropService.updateCrop(crop,id);
        return "Updated Successfully";
    }
		
	@GetMapping("/deletecrop/{id}")
	public String deletecrop( @PathVariable String id )	{
		cropService.deleteCrop(id);
		return "Deleted Successfully";
	}
		
}
