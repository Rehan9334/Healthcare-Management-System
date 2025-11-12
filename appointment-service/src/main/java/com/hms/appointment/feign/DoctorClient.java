package com.hms.appointment.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="doctor-service")
public interface DoctorClient {

	@GetMapping("/api/doctors/{id}")
	Map<String, Object> getDoctorById(@PathVariable("id") Long id);
		
	
}
