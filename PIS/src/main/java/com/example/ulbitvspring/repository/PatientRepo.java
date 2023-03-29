package com.example.ulbitvspring.repository;

import com.example.ulbitvspring.entity.PatientEntity;
import com.example.ulbitvspring.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatientRepo extends CrudRepository<PatientEntity, Long> {
    PatientEntity findBySurname(String surname);

    List<PatientEntity> findAll();
}
