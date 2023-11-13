package com.devlink.webservice.controller;
import com.devlink.webservice.entities.Developer;
import com.devlink.webservice.entities.Recruiter;
import com.devlink.webservice.service.IRecruiterService;
import com.devlink.webservice.controller.RecruiterController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class RecruiterControllerTest {
    @Mock
    private IRecruiterService recruiterService;

    @InjectMocks
    private RecruiterController recruiterController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateRecruiter() {
        Recruiter recruiter = new Recruiter();
        try {
            when(recruiterService.save(recruiter)).thenReturn(recruiter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ResponseEntity<Recruiter> response = recruiterController.createRecruiter(recruiter);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(recruiter, response.getBody());
        try {
            verify(recruiterService, times(1)).save(recruiter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetAllRecruiters() throws Exception {

        List<Recruiter> recruiters = Arrays.asList(new Recruiter(), new Recruiter());
        try {
            when(recruiterService.getAll()).thenReturn(recruiters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ResponseEntity<List<Recruiter>> response = recruiterController.getAllRecruiters();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(recruiters, response.getBody());
    }

    @Test
    void testGetRecruiterById() {
        Long id = 1L;
        Recruiter recruiter = new Recruiter();
        try {
            when(recruiterService.getById(id)).thenReturn(Optional.of(recruiter));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ResponseEntity<Recruiter> response = recruiterController.getRecruiterById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(recruiter, response.getBody());
        try {
            verify(recruiterService, times(1)).getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}