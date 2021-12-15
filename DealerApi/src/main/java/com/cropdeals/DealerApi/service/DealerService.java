package com.cropdeals.DealerApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cropdeals.DealerApi.models.Crops;
import com.cropdeals.DealerApi.models.Dealer;
import com.cropdeals.DealerApi.models.FarmerProfile;
import com.cropdeals.DealerApi.models.ReturnAllCrops;
import com.cropdeals.DealerApi.repository.DealerRepo;

@Service
public class DealerService {

	@Autowired
	private DealerRepo repos;
	
	@Autowired
	private RestTemplate restTemplate;

	public void addDealer(Dealer dealer) {
		repos.insert(dealer);
	}

	public List<Dealer> showAllDealers() {
		return repos.findAll();	
	}

	public Dealer findDealerByName(String dealerName) {
		return repos.findOrdersByName(dealerName);
	}

	public Optional<Dealer> findDealerById(String id) {
		return repos.findById(id);
	}

	public String upsateDealer(Dealer dealer, String id) {
		dealer.setId(id);
		repos.save(dealer);
        return "Updated Successfully";
	}

	public String deleteDealer(String id) {
		repos.deleteById(id);
		return "Deleted Successfully";
	}

	public String giveRating(FarmerProfile farmerProfile, String id) {
		restTemplate.put("http://farmerApi/farmer/rating/"+id, farmerProfile,FarmerProfile.class);
		return "rated successfully";
	}

	public List<Crops> showAllCrops() {
		ReturnAllCrops allCrops = restTemplate.getForObject("http://crop-avalilable/crops/allcrops", ReturnAllCrops.class);
		return allCrops.getListOfCrops();
	}

	public String buyCrop(Crops crops, String id) {
		restTemplate.put("http://crop-avalilable/crops/buycrop/"+id, crops);
		return "requested to buy";
	}

	public List<Crops> showSubscribedCrops(String id) {
		Dealer dealer = repos.findByID(id);
		ReturnAllCrops allCrops = restTemplate.getForObject("http://crop-avalilable/crops/allcrops", ReturnAllCrops.class);
		List<Crops> crops = new ArrayList<Crops>();
		for (String name : dealer.getSubscribedCrops()) {
			crops.addAll(allCrops.getListOfCrops().stream().filter(l -> l.getCropName().equalsIgnoreCase(name)).toList());	
		}
		return  crops;
		
	}
	
}
