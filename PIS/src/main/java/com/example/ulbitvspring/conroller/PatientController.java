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
        import java.util.Objects;



        import org.springframework.core.io.ClassPathResource;
        import org.springframework.core.io.Resource;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    @RequestMapping(value = "/patients/new")
    public ResponseEntity registration(@RequestBody PatientEntity patient) {
        try {
            patientService.registration(patient);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

//    @GetMapping("/patients")
//    public String listPatients(Model model) {
//        model.addAttribute("patients", patientService.getAll());
//        return "patients";
//    }

    private final ResourceLoader resourceLoader;

    public PatientController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @RequestMapping(value = "/patients", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> listPatients() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:templates/patients.html");
        String html = new String(Objects.requireNonNull(resource.getInputStream().readAllBytes()), StandardCharsets.UTF_8);
        return ResponseEntity.ok().body(html);
    }


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

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(patientService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
