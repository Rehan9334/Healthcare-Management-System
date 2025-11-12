package com.hms.appointment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.appointment.model.Appointment;
import com.hms.appointment.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	@PostMapping
	public Appointment add(@RequestBody Appointment appointment) {
		return service.save(appointment);
	}
	
	@GetMapping
	public List<Appointment> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/summary/{doctorId}")
    public Map<String, Object> getSummary(@PathVariable Long doctorId) {
        return service.getAppointmentSummary(doctorId);
    }
}
