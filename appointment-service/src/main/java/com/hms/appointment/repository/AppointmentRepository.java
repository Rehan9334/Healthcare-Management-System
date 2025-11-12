package com.hms.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.appointment.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByDoctorId(Long doctorId);
}
