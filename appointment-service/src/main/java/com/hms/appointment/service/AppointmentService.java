package com.hms.appointment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.appointment.feign.DoctorClient;
import com.hms.appointment.feign.PatientClient;
import com.hms.appointment.model.Appointment;
import com.hms.appointment.repository.AppointmentRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AppointmentService {

	@Autowired
	private  AppointmentRepository repo;
	
	@Autowired
    private DoctorClient doctorClient;

    @Autowired
    private PatientClient patientClient;
    
    public Appointment save(Appointment appointment) {
    	return repo.save(appointment);
    }
    
    public List<Appointment> getAll(){
    	return repo.findAll();
    }
    
    @CircuitBreaker(name="doctorService", fallbackMethod = "doctorFallback")
    public Map<String,Object> getAppointmentSummary(Long doctorId){
    	Map<String,Object> response=new HashMap<>();
    	List<Appointment> appointments=repo.findByDoctorId(doctorId);
    	
    	Map<String, Object> doctor = doctorClient.getDoctorById(doctorId);

        List<Map<String, Object>> details = new ArrayList<>();
        
        for (Appointment appt : appointments) {
            Map<String, Object> patient = patientClient.getPatientById(appt.getPatientId());
            Map<String, Object> map = new HashMap<>();
            map.put("appointmentDate", appt.getAppointmentDate());
            map.put("status", appt.getStatus());
            map.put("patient", patient);
            details.add(map);
        }

        response.put("doctor", doctor);
        response.put("appointments", details);
        return response;
    }

    public Map<String, Object> doctorFallback(Long doctorId, Throwable t) {
        Map<String, Object> response = new HashMap<>();
        response.put("doctorId", doctorId);
        response.put("message", "Doctor service is unavailable, please try again later.");
        return response;
    }
    
    
}
