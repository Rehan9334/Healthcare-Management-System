package com.hms.patient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.patient.model.Patient;
import com.hms.patient.service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

	private final PatientService service;
	
	@GetMapping("{id}")
	public Patient getPatients(@PathVariable Long id) {
		return service.getById(id);
	}
	

	@GetMapping
	public List<Patient> getAllPatients(){
		return service.getAll();
	}
	
	@PostMapping
	public Patient create(@RequestBody Patient patient) {
		return service.save(patient);
	}
	
	@PutMapping()
	public Patient update(@RequestBody Patient patient) {
		return service.save(patient);
	}
   
	@DeleteMapping("/cache")
	public void clearCache(Long id) {
		service.clearCache();
	}
}
