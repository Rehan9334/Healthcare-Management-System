package com.hms.patient.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hms.patient.model.Patient;
import com.hms.patient.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repo;

    // ✅ Fetch single patient by ID (cache result)
    @Cacheable(value = "patients", key = "#id")
    public Patient getById(Long id) {
        System.out.println("Fetching from DB for id: " + id);
        return repo.findById(id).orElse(null);
    }

    // ✅ Fetch all patients (cache list)
    @Cacheable(value = "patientsList")
    public List<Patient> getAll() {
        System.out.println("Fetching all patients from DB...");
        return repo.findAll();
    }

    // ✅ Save and update cache entry safely
    @CachePut(value = "patients", key = "#result?.id")
    @CacheEvict(value = "patientsList", allEntries = true) // refresh list cache
    public Patient save(Patient patient) {
        Patient saved = repo.save(patient);
        System.out.println("Saved patient: " + saved.getId());
        return saved;
    }

    // ✅ Clear all cache manually
    @CacheEvict(value = {"patients", "patientsList"}, allEntries = true)
    public void clearCache() {
        System.out.println("Cache cleared!");
    }
}
