package com.hms.doctors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.doctors.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
