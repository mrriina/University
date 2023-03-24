package com.example.ulbitvspring.service;

import com.example.ulbitvspring.entity.PatientEntity;
import com.example.ulbitvspring.exception.UserAlreadyExistException;
import com.example.ulbitvspring.exception.UserNotFoundException;
import com.example.ulbitvspring.model.Patient;
import com.example.ulbitvspring.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public PatientEntity registration(PatientEntity patient) throws UserAlreadyExistException {
        return patientRepo.save(patient);
    }

    public Patient getOne(Long id) throws UserNotFoundException {
        PatientEntity patient = patientRepo.findById(id).get();
        if (patient == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return Patient.toModel(patient);
    }

    public List<Patient> getAll() {
        List<PatientEntity> patients = patientRepo.findAll();

        return patients.stream().map(Patient::toModel).collect(Collectors.toList());
    }

    public Long delete(Long id) {
        patientRepo.deleteById(id);
        return id;
    }
}
