package com.cropdeals.FarmerApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FarmerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmerApiApplication.class, args);
	}

}
