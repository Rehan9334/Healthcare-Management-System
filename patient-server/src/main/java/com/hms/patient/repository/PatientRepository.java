package com.hms.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.patient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
