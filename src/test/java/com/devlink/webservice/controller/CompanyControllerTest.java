package com.devlink.webservice.controller;

import com.devlink.webservice.controller.CompanyController;
import com.devlink.webservice.entities.Company;
import com.devlink.webservice.service.ICompanyService;
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

class CompanyControllerTest {
    @Mock
    private ICompanyService companyService;

    @InjectMocks
    private CompanyController companyController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCreateCompany(){
        // Arrange
        Company company = new Company();
        try {
            when(companyService.save(company)).thenReturn(company);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<Company> response = companyController.createCompany(company);

        // Assert
        try {
            verify(companyService, times(1)).save(company);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.CREATED);
    }
    @Test
    void testGetAllCompanies() {
        // Arrange
        List<Company> companies = Arrays.asList(new Company(), new Company());
        try {
            when(companyService.getAll()).thenReturn(companies);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<List<Company>> response = companyController.getAllCompanies();

        // Assert
        try {
            verify(companyService, times(1)).getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.OK);
        // Puedes hacer más aserciones según tu lógica específica.
    }

    @Test
    void testGetCompanyById() {
        // Arrange
        Long companyId = 1L;
        Company company = new Company();
        try {
            when(companyService.getById(companyId)).thenReturn(Optional.of(company));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<Company> response = companyController.getCompanyById(companyId);

        // Assert
        try {
            verify(companyService, times(1)).getById(companyId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.OK);
        // Puedes hacer más aserciones según tu lógica específica.
    }

    @Test
    void testUpdateCompany() {
        // Arrange
        Long companyId = 1L;
        Company updatedCompany = new Company();
        try {
            when(companyService.updateCompany(companyId, updatedCompany)).thenReturn(updatedCompany);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<Company> response = companyController.updateCompany(companyId, updatedCompany);

        // Assert
        try {
            verify(companyService, times(1)).updateCompany(companyId, updatedCompany);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.OK);
        // Puedes hacer más aserciones según tu lógica específica.
    }

    @Test
    void testDeleteCompany() {
        // Arrange
        Long companyId = 1L;

        // Act
        ResponseEntity<Void> response = companyController.deleteCompany(companyId);

        // Assert
        try {
            verify(companyService, times(1)).delete(companyId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.NO_CONTENT);
    }

}