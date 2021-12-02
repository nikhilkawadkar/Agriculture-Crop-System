package com.cropdeals.FarmerApi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
 
import com.cropdeals.FarmerApi.Services.ProfileServices;
 
import com.cropdeals.FarmerApi.models.FarmerProfile;
import com.cropdeals.FarmerApi.models.ReturnAllCrops;
import com.cropdeals.FarmerApi.models.Crops;
import com.cropdeals.FarmerApi.repository.ProfileRepo;
 

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	
	@Autowired
	ProfileRepo profileRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProfileServices profileServices;
	
	@Bean
	public void addtoServiceclass() {
		profileServices.addlist(profileRepo.findAll());
	} 
	
	@PostMapping("/addfarmer")
	public void addFarmer( @RequestBody FarmerProfile farmerProfile ) {
		profileRepo.insert( farmerProfile );
	}
	
	@PostMapping("/addcrop")
	public void addCrops(@RequestBody Crops crop ) {
		restTemplate.postForEntity("http://localhost:8084/crops/addCrop", crop,Crops.class);
	}

	@GetMapping("/allfarmers")
	public List<FarmerProfile> showAllFarmers() {
		return profileRepo.findAll();		
	}
	
	
	@GetMapping("/allmycrops/{farmerId}")
	public ReturnAllCrops showMyCrops(@PathVariable String farmerId) {
		
		return  restTemplate.getForObject("http://localhost:8084/crops/findmycrop/"+farmerId, ReturnAllCrops.class);
		
	}
	
	@GetMapping("/allcrops")
	public List<Crops> showAllCrops() {
		
		ReturnAllCrops allCrops = restTemplate.getForObject("http://localhost:8084/crops/allcrops", ReturnAllCrops.class);
		return allCrops.getListOfCrops();
	}
	
	@GetMapping("/findfarmer/{itemName}")
	public FarmerProfile findOrder ( @PathVariable String itemName ){
		return profileRepo.findOrdersByName( itemName );
	}
	
	@PutMapping("/update/{id}")
    public String updateOrder(@RequestBody FarmerProfile order, @PathVariable String id) {
        order.setId( id );
        profileRepo.save(order);
        return ("Updated Successfully");
    }
	
	@GetMapping("/deletecrop/{id}")
	public String deleteCrop( @PathVariable String id )	{
		
		 return restTemplate.getForObject("http://localhost:8084/crops/delete/"+id, String.class);

	}
	
	@GetMapping("/deleteFfarmer/{id}")
	public String deleteFarmer( @PathVariable String id )	{
		profileRepo.deleteById( id );
		return ("Deleted Successfully");
	}
}