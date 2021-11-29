package com.cropdeals.DealerApi;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealerController {

	@GetMapping("/dealer")
	public String helloDealer() {
		return "hello i am a dealer";
	}
	
}
