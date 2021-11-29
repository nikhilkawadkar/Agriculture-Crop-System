package com.cropdeals.DealerApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DealerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerApiApplication.class, args);
	}

}
