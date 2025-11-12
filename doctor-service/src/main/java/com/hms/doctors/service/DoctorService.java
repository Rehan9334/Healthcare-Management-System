package com.hms.doctors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hms.doctors.model.Doctor;
import com.hms.doctors.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {

	@Autowired
	private final DoctorRepository repo;
	
	@Cacheable("doctors")
	public List<Doctor> getAllDoctors(){
		return repo.findAll();
	}
	
	@Cacheable(value = "doctor", key = "#id")
	public Optional<Doctor> getDoctorById(Long id){
		return repo.findById(id);
	}
	
	public Doctor saveDoctor(Doctor doctor) {
		return repo.save(doctor);
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
}
