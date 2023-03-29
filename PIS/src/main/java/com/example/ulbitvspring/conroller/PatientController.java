package com.example.ulbitvspring.conroller;

import com.example.ulbitvspring.entity.PatientEntity;
import com.example.ulbitvspring.exception.UserAlreadyExistException;
import com.example.ulbitvspring.exception.UserNotFoundException;
import com.example.ulbitvspring.repository.PatientRepo;
import com.example.ulbitvspring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Objects;

import org.thymeleaf.context.Context;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@RestController
public class PatientController {

    public PatientController(){}

    @Autowired
    private PatientService patientService;

//    private final ResourceLoader resourceLoader;
//
//    public PatientController(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }

    @PostMapping
    @RequestMapping(value = "/patients/new")
    public ResponseEntity registration(@RequestBody PatientEntity patient) {
        try {
            patientService.registration(patient);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


//    @RequestMapping(value = "/patients", produces = MediaType.TEXT_HTML_VALUE)
//    public String listPatients(Model model) {
//        model.addAttribute("patients", patientService.getAll());
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        templateResolver.setPrefix("templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML");
//        templateResolver.setCharacterEncoding("UTF-8");
//        templateEngine.setTemplateResolver(templateResolver);
//        return templateEngine.process("patients", new Context(Locale.getDefault(), model.asMap()));
//    }


    @GetMapping
    public ResponseEntity getOnePatient(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(patientService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/patients/{id}")
    public String deletePatient(@PathVariable Long id) {
        try {
            patientService.delete(id);
            return "redirect:/patients";
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Произошла ошибка");
            return "Произошла ошибка";
        }
    }
}
