package com.example.ulbitvspring.model;

import com.example.ulbitvspring.entity.PatientEntity;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;


public class Patient {

    private Long id;

    private String name;

    private String surname;

    private String patronymic;

    private String doctor;

    public static Patient toModel(PatientEntity entity) {
        Patient model = new Patient();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setPatronymic(entity.getPatronymic());
        model.setDoctor(entity.getDoctor());
        return model;
    }


    public Patient() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
