package com.example.ulbitvspring;

import com.example.ulbitvspring.conroller.PatientController;
import com.example.ulbitvspring.entity.PatientEntity;
import com.example.ulbitvspring.repository.PatientRepo;
import com.example.ulbitvspring.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
public class PatientServiceTests {

    @Autowired
    private PatientRepo patientRepository;

    @Autowired
    private PatientService patientService;



    @Test
    @Order(1)
    @Rollback(value = false)
    public void registrationTest() {
        // Arrange
        PatientEntity patient1 = new PatientEntity();
        patient1.setName("John");
        patient1.setSurname("Doe");
        patient1.setPatronymic("Yhnov");
        patient1.setDoctor("pediatrician");

        patientService.registration(patient1);
        System.out.println("patient1.getId()="+patient1.getId());
        Assertions.assertTrue(patient1.getId() > 0);

//        Mockito.when(patientRepository.save(patient1)).thenReturn(patient1);
//
//        // Act
//        PatientEntity result = patientService.registration(patient1);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(patient1.getName(), result.getName());
//        assertEquals(patient1.getSurname(), result.getSurname());
//        assertEquals(patient1.getPatronymic(), result.getPatronymic());
//        assertEquals(patient1.getDoctor(), result.getDoctor());
    }
}

















//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PatientRepo repo;



//    ResourceLoader resourceLoader = new DefaultResourceLoader();
//    Resource resource = resourceLoader.getResource("classpath:patientsTest.html");
//    PatientController controller = new PatientController(resourceLoader);

//    @Test
//    public void listPatientsTest() throws Exception {
//        mockMvc.perform(get("/patients"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("patients"))
//                .andExpect(model().attribute("template", "patients.html"));
//
//    }


//    @Test
//    public void testRegistration() throws Exception {
//        PatientEntity patient1 = new PatientEntity();
//        patient1.setId(1L);
//        patient1.setName("John");
//        patient1.setSurname("Doe");
//        patient1.setPatronymic("Yhnov");
//        patient1.setDoctor("pediatrician");
//
//        PatientEntity patient2 = new PatientEntity();
//        patient2.setId(2L);
//        patient2.setName("John2");
//        patient2.setSurname("Doe2");
//        patient2.setPatronymic("Yhnov2");
//        patient2.setDoctor("therapist");
//
////        when(repo.findAll()).thenReturn(Arrays.asList(patient1, patient2));
////        mockMvc.perform(get("/patients"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$", hasSize(2)))
////                .andExpect(jsonPath("$[*].surname", containsInAnyOrder("Doe", "Doe2")));
//
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(patient1);
//
//        mockMvc.perform(post("/patients/new")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk());
//
//        verify(patientService, times(1)).registration(patient);
//
//    }

//    @Test
//    public void testRegistration() throws Exception {
//        PatientEntity patient = new PatientEntity();
//        patient.setId(1L);
//        patient.setName("John");
//        patient.setSurname("Doe");
//        patient.setPatronymic("Yhnov");
//        patient.setDoctor("pediatrician");
//
//        // Мок сервиса пациентов
//        PatientService patientService = mock(PatientService.class);
//
//        // Объект контроллера
//        PatientController controller = new PatientController();
//
//        // Ожидаемое сообщение в случае успешного сохранения пациента
//        String expectedMessage = "Пользователь успешно сохранен";
//
//        // Выполнение метода контроллера
//        ResponseEntity response = controller.registration(patient);
//
//        // Проверка статуса ответа
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//
//        // Проверка сообщения в ответе
//        assertEquals(expectedMessage, response.getBody());
//
//        // Проверка вызова сервиса с переданным пациентом
//        verify(patientService, times(1)).registration(patient);
//    }

//    public static String asJsonString(final Object obj) {
//        try {
//            final ObjectMapper mapper = new ObjectMapper();
//            final String jsonContent = mapper.writeValueAsString(obj);
//            return jsonContent;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

