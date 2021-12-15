package com.cropdeals.FarmerApi.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cropdeals.FarmerApi.models.Crops;
import com.cropdeals.FarmerApi.models.FarmerProfile;
import com.cropdeals.FarmerApi.models.ReturnAllCrops;
import com.cropdeals.FarmerApi.repository.ProfileRepo;

@Service
public class ProfileServices implements UserDetailsService{
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public void addFarmer(FarmerProfile farmerProfile) {
		profileRepo.insert(farmerProfile);
	}

	public List<FarmerProfile> showAllFarmer() {
		return profileRepo.findAll();
	}

	public FarmerProfile findFarmerByName(String farmerName) {
		return profileRepo.findByfName(farmerName);
	}

	public void giveRating(FarmerProfile farmerProfile, String id) {
		farmerProfile.setId( id );  
        Integer rating= farmerProfile.getAllRatings().stream().mapToInt(Integer::intValue).sum()/farmerProfile.getAllRatings().size();
        farmerProfile.setRating(rating);
        profileRepo.save(farmerProfile);
	}

	public String updateFarmer(FarmerProfile farmerProfile, String id) {
		farmerProfile.setId( id );  
        profileRepo.save(farmerProfile);
        return "Updated Successfully";
	}

	public String deleteFarmer(String id) {
		profileRepo.deleteById( id );
		return "Deleted Successfully";
	}

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		FarmerProfile foundedfarmer = profileRepo.findByfName(username);
		if (foundedfarmer ==null) return null;
		String fName = foundedfarmer.getfName();
		String fPassword = foundedfarmer.getfPassword();
		return new User(fName, fPassword, new ArrayList<>());
	}

	public String authFarmer(FarmerProfile farmerProfile) {
		String fName = farmerProfile.getfName();
		String Password = farmerProfile.getfPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(fName, Password));
		} catch (Exception e) {
			 
			return e.getLocalizedMessage();
		}
		return "Successfully Authenticated customer " + fName;
	}

}
