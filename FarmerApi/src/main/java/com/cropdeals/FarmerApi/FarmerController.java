package com.cropdeals.FarmerApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	
	@GetMapping("/farm")
	public String helloFarmer() {
		return "hello i am a Farmer";
	}

}
