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
 
 

@RestController
@EnableEurekaClient
@RequestMapping("/dealer")
public class DealerController {

	@Autowired
	DealerRepo repos;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/addDealer")
	public void placeOrder( @RequestBody Dealer order ) {
		repos.insert( order );
	}
	
	@GetMapping("/allcrops")
	public List<Crops>showAllCrops() {
		ReturnAllCrops allCrops = restTemplate.getForObject("http://crop-avalilable/crops/allcrops", ReturnAllCrops.class);
		return allCrops.getListOfCrops();
	}
	
	@GetMapping("/all")
	public List<Dealer> showAllOrders() {
		return repos.findAll();		
	}
	
	 
	@GetMapping("/allmycrops/{farmerId}")
	public String showMyCrops(@PathVariable String farmerId) {
		return  restTemplate.getForObject("http://crop-avalilable/crops/findmycrop/"+farmerId, String.class);
	}

	@GetMapping("/finddealer/{itemName}")
	public Dealer findOrder ( @PathVariable String itemName ){
		return repos.findOrdersByName( itemName );
	}
	
	
	
	
	@GetMapping("/finddealerbyid/{id}")
	public Optional<Dealer> finddealerbyid( @PathVariable String id ){
		return repos.findById( id );
	}
	
	
	@PutMapping("/giverating/{id}")
    public String giveRatings(@RequestBody FarmerProfile farmerProfile, @PathVariable String id) {
	 
	restTemplate.put("http://FarmerApi/farmer/rating/"+id, farmerProfile);
	return "rated successfully";
    }
	
	@PutMapping("/buycrop/{id}")
    public String buycrop(@RequestBody FarmerProfile farmerProfile, @PathVariable String id) {
	 
	restTemplate.put("http://localhost:8084/crops/buycrop/"+id, farmerProfile);
	return "requested successfully";
    }
	
	
	@PutMapping("/update/{id}")
    public String updateOrder(@RequestBody Dealer dealer, @PathVariable String id) {
		dealer.setId( id );
		repos.save(dealer);
        return ("Updated Successfully");
    }
		
	@GetMapping("/delete/{id}")
	public String deleteOrder( @PathVariable String id )	{
		repos.deleteById( id );
		return ("Deleted Successfully");
	}

	
}
