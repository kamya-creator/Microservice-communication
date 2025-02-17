package com.addressapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddressappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressappApplication.class, args);
	}

}
