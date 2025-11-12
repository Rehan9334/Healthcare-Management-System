package com.hms.appointment.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="patient-server")
public interface PatientClient {

	@GetMapping("/api/patients/{id}")
	Map<String,Object> getPatientById(@PathVariable("id") Long id);
}
