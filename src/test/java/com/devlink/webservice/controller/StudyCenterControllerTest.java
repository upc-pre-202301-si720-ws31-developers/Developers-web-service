package com.devlink.webservice.controller;

import com.devlink.webservice.entities.StudyCenter;
import com.devlink.webservice.service.IStudyCenterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class StudyCenterControllerTest {

    @Mock
    private IStudyCenterService studyCenterService;

    @InjectMocks
    private StudyCenterController studyCenterController;

    @BeforeEach
    void setUp() {
        // Inicializar anotaciones Mockito
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCreateStudyCenter() {
        // Crear un objeto de estudio ficticio para la prueba
        StudyCenter studyCenterToUpdate = new StudyCenter();
        studyCenterToUpdate.setId(1L);
        studyCenterToUpdate.setName("Updated University");
        studyCenterToUpdate.setLocation("Updated City, Country");

        // Crear un servicio ficticio utilizando Mockito
        IStudyCenterService studyCenterService = mock(IStudyCenterService.class);

        // Configurar el comportamiento del servicio ficticio para el método de actualización
        try {
            when(studyCenterService.updateStudyCenter(eq(1L), any(StudyCenter.class)))
                    .thenReturn(studyCenterToUpdate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Crear un controlador con el servicio ficticio
        StudyCenterController studyCenterController = new StudyCenterController(studyCenterService);

        // Llamar al método de actualización del controlador
        ResponseEntity<StudyCenter> responseEntity = studyCenterController.updateStudyCenter(1L, studyCenterToUpdate);

        // Verificar que la respuesta sea exitosa y contenga el estudio actualizado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(studyCenterToUpdate, responseEntity.getBody());

        // Verificar que el método de actualización del servicio se llamó con los parámetros correctos
        try {
            verify(studyCenterService, times(1)).updateStudyCenter(eq(1L), any(StudyCenter.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetAllStudyCenters() {
        // Crear una lista de centros de estudio para simular la respuesta del servicio
        List<StudyCenter> studyCenters = new ArrayList<>();
        studyCenters.add(new StudyCenter(1L, "University A", "City A"));
        studyCenters.add(new StudyCenter(2L, "College B", "City B"));

        // Configurar el comportamiento del servicio mock
        try {
            when(studyCenterService.getAll()).thenReturn(studyCenters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Llamar al método del controlador que queremos probar
        ResponseEntity<List<StudyCenter>> response = studyCenterController.getAllStudyCenters();

        // Verificar que la respuesta sea la esperada
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(studyCenters, response.getBody());

        // Verificar que el método del servicio se haya llamado una vez
        try {
            verify(studyCenterService, times(1)).getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetStudyCenterById() {
        Long id = 1L;
        StudyCenter studyCenter = new StudyCenter(id, "University A", "City A");

        // Configurar el comportamiento del servicio mock al llamar a getById
        try {
            when(studyCenterService.getById(id)).thenReturn(Optional.of(studyCenter));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Llamar al método del controlador que queremos probar
        ResponseEntity<StudyCenter> response = studyCenterController.getStudyCenterById(id);

        // Verificar que la respuesta sea la esperada
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(studyCenter, response.getBody());

        // Verificar que el método del servicio se haya llamado una vez
        try {
            verify(studyCenterService, times(1)).getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testUpdateStudyCenter() {
        Long id = 1L;
        StudyCenter updatedStudyCenter = new StudyCenter(id, "University A", "City A");

        // Configurar el comportamiento del servicio mock al llamar a updateStudyCenter
        try {
            when(studyCenterService.updateStudyCenter(id, updatedStudyCenter)).thenReturn(updatedStudyCenter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Llamar al método del controlador que queremos probar
        ResponseEntity<StudyCenter> response = studyCenterController.updateStudyCenter(id, updatedStudyCenter);

        // Verificar que la respuesta sea la esperada
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedStudyCenter, response.getBody());

        // Verificar que el método del servicio se haya llamado una vez
        try {
            verify(studyCenterService, times(1)).updateStudyCenter(id, updatedStudyCenter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testDeleteStudyCenter() {
        Long id = 1L;

        // Llamar al método del controlador que queremos probar
        ResponseEntity<Void> response = studyCenterController.deleteStudyCenter(id);

        // Verificar que la respuesta sea la esperada
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        // Verificar que el método del servicio se haya llamado una vez
        try {
            verify(studyCenterService, times(1)).delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}