package com.cropdeals.DealerApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cropdeals.DealerApi.models.Crops;
import com.cropdeals.DealerApi.models.Dealer;
import com.cropdeals.DealerApi.models.FarmerProfile;
import com.cropdeals.DealerApi.models.ReturnAllCrops;
import com.cropdeals.DealerApi.repository.DealerRepo;
import com.cropdeals.DealerApi.service.DealerService;

@RestController
@EnableEurekaClient
@RequestMapping("/dealer")
public class DealerController {

	@Autowired
	DealerRepo repos;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private DealerService dealerService; 
	
	@PostMapping("/adddealer")
	public void addDealer(@RequestBody Dealer dealer) {
		dealerService.addDealer(dealer);
	}
	
	@GetMapping("/alldealers")
	public List<Dealer> showAllDealers() {
		return dealerService.showAllDealers();	
	}
	
	@GetMapping("/finddealer/{dealerName}")
	public Dealer findDealerByName(@PathVariable String dealerName){
		return dealerService.findDealerByName(dealerName);
	}
	
	@GetMapping("/finddealerbyid/{id}")
	public Optional<Dealer> finddealerbyid( @PathVariable String id ){
		return dealerService.findDealerById(id);
	}
	
	@PutMapping("/updatedealer/{id}")
    public String updateDealer(@RequestBody Dealer dealer, @PathVariable String id) {
		return dealerService.upsateDealer(dealer,id);
    }
		
	@GetMapping("/deleteDealer/{id}")
	public String deleteOrder(@PathVariable String id) {
		return dealerService.deleteDealer(id);
	}
	
	//farmer operations
	
	@PutMapping("/giverating/{id}")
    public String giveRatings(@RequestBody FarmerProfile farmerProfile, @PathVariable String id) { 
		return dealerService.giveRating(farmerProfile,id);
    }
	
	//Crop operations
	
	@GetMapping("/allcrops")
	public List<Crops>showAllCrops() {
		return dealerService.showAllCrops();
	}
	
	@PutMapping("/buycrop/{id}")
    public String buycrop(@RequestBody Crops crops, @PathVariable String id) {
		return dealerService.buyCrop(crops,id);
    }
	
	@GetMapping("/subscribedcropa/{id}")
	public List<Crops> showSubscribedCrops(@PathVariable String id) {
		return dealerService.showSubscribedCrops(id);
	}
	
}
