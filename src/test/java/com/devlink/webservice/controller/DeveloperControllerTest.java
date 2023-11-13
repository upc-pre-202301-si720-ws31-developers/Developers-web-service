package com.devlink.webservice.controller;

import com.devlink.webservice.entities.Developer;
import com.devlink.webservice.service.IDeveloperService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class DeveloperControllerTest {

    @Mock
    private IDeveloperService developerService;

    @InjectMocks
    private DeveloperController developerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDeveloper() {
        Developer inputDeveloper = new Developer();
        Developer createdDeveloper = new Developer();
        try {
            when(developerService.save(inputDeveloper)).thenReturn(createdDeveloper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ResponseEntity<Developer> response = developerController.createDeveloper(inputDeveloper);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdDeveloper, response.getBody());
    }

    @Test
    void getAllDevelopers_shouldReturnListOfDevelopers() {
        List<Developer> developers = Arrays.asList(new Developer(), new Developer());
        try {
            when(developerService.getAll()).thenReturn(developers);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ResponseEntity<List<Developer>> response = developerController.getAllDevelopers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(developers, response.getBody());
    }

    @Test
    void getAllDevelopers_shouldReturnNoContentWhenListIsEmpty() {
        try {
            when(developerService.getAll()).thenReturn(List.of());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ResponseEntity<List<Developer>> response = developerController.getAllDevelopers();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void getDeveloperById_shouldReturnDeveloperWhenFound() {
        Long developerId = 1L;
        Developer foundDeveloper = new Developer();
        try {
            when(developerService.getById(developerId)).thenReturn(Optional.of(foundDeveloper));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ResponseEntity<Developer> response = developerController.getDeveloperById(developerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(foundDeveloper, response.getBody());
    }
    @Test
    void updateDeveloper_shouldReturnUpdatedDeveloper() {
        Long developerId = 1L;
        Developer updatedDeveloper = new Developer();
        try {
            when(developerService.updateDeveloper(developerId, updatedDeveloper)).thenReturn(updatedDeveloper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ResponseEntity<Developer> response = developerController.updateDeveloper(developerId, updatedDeveloper);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedDeveloper, response.getBody());
    }

    @Test
    void deleteDeveloper_shouldReturnNoContent() {
        Long developerId = 1L;

        ResponseEntity<Void> response = developerController.deleteDeveloper(developerId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        try {
            verify(developerService, times(1)).delete(developerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}