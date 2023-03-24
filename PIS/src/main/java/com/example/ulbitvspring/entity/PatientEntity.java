package com.example.ulbitvspring.entity;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    private String patronymic;

    private String doctor;


    public PatientEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDoctor() {
        return doctor;
    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
