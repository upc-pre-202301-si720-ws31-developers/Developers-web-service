package com.devlink.webservice.controller;
import com.devlink.webservice.controller.EducationController;
import com.devlink.webservice.entities.Education;
import com.devlink.webservice.service.IEducationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
class EducationControllerTest {

    @Mock
    private IEducationService educationService;

    @InjectMocks
    private EducationController educationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCreateEducation() {
        // Arrange
        Education education = new Education();
        try {
            when(educationService.save(education)).thenReturn(education);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<Education> response = educationController.createEducation(education);

        // Assert
        try {
            verify(educationService, times(1)).save(education);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.CREATED);
    }

    @Test
    void testGetAllEducations() {
        // Arrange
        List<Education> educations = Arrays.asList(new Education(), new Education());
        try {
            when(educationService.getAll()).thenReturn(educations);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<List<Education>> response = educationController.getAllEducations();

        // Assert
        try {
            verify(educationService, times(1)).getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    void testGetEducationById() {
        // Arrange
        Long educationId = 1L;
        Education education = new Education();
        try {
            when(educationService.getById(educationId)).thenReturn(Optional.of(education));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<Education> response = educationController.getEducationById(educationId);

        // Assert
        try {
            verify(educationService, times(1)).getById(educationId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    void testGetEducationByIdNotFound() {
        // Arrange
        Long educationId = 1L;
        try {
            when(educationService.getById(educationId)).thenReturn(Optional.empty());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<Education> response = educationController.getEducationById(educationId);

        // Assert
        try {
            verify(educationService, times(1)).getById(educationId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.NOT_FOUND);
    }

    @Test
    void testUpdateEducation() {
        // Arrange
        Long educationId = 1L;
        Education updatedEducation = new Education();
        try {
            when(educationService.updateEducation(educationId, updatedEducation)).thenReturn(updatedEducation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<Education> response = educationController.updateEducation(educationId, updatedEducation);

        // Assert
        try {
            verify(educationService, times(1)).updateEducation(educationId, updatedEducation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    void testDeleteEducation() {
        // Arrange
        Long educationId = 1L;

        // Act
        ResponseEntity<Void> response = educationController.deleteEducation(educationId);

        // Assert
        try {
            verify(educationService, times(1)).delete(educationId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.NO_CONTENT);
    }
}