package com.hms.doctors.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.doctors.model.Doctor;
import com.hms.doctors.service.DoctorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

	@Autowired
	private final DoctorService service;
	
	
	@GetMapping
	public List<Doctor> getAll(){
		return service.getAllDoctors();
	}
	
	@GetMapping("/{id}")
	public Optional<Doctor> getById(@PathVariable Long id) {
		return service.getDoctorById(id);
	}
	
	@PostMapping
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return service.saveDoctor(doctor);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return "Doctor deleted successfully";
	}
}
