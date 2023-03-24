package com.example.ulbitvspring.repository;

import com.example.ulbitvspring.entity.PatientEntity;
import com.example.ulbitvspring.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepo extends CrudRepository<PatientEntity, Long> {
    PatientEntity findBySurname(String surname);

    List<PatientEntity> findAll();
}
