package com.hms.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class PatientServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientServerApplication.class, args);
	}

}
