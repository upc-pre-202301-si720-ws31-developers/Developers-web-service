package com.devlink.webservice.entities;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RecruiterTest {

    @Test
    void testCreateRecruiter() {
        Company company = new Company();
        company.setId(1L);

        Recruiter recruiter = new Recruiter();
        recruiter.setId(1L);
        recruiter.setName("John");
        recruiter.setLastname("Doe");
        recruiter.setUsername("john.doe");
        recruiter.setPhoto("profile.jpg");
        recruiter.setEmail("john.doe@example.com");
        recruiter.setPhone("123456789");
        recruiter.setRegion("US");
        recruiter.setBirthdate(LocalDate.of(1990, 5, 15));
        recruiter.setPassword("password123");
        recruiter.setDescription("Experienced recruiter");
        recruiter.setCompany(company);

        assertEquals(1L, recruiter.getId());
        assertEquals("John", recruiter.getName());
        assertEquals("Doe", recruiter.getLastname());
        assertEquals("john.doe", recruiter.getUsername());
        assertEquals("profile.jpg", recruiter.getPhoto());
        assertEquals("john.doe@example.com", recruiter.getEmail());
        assertEquals("123456789", recruiter.getPhone());
        assertEquals("US", recruiter.getRegion());
        assertEquals(LocalDate.of(1990, 5, 15), recruiter.getBirthdate());
        assertEquals("password123", recruiter.getPassword());
        assertEquals("Experienced recruiter", recruiter.getDescription());
        assertEquals(company, recruiter.getCompany());
    }

    @Test
    void testCreateRecruiterWithoutPhotoAndCompany() {
        Recruiter recruiter = new Recruiter();
        recruiter.setId(2L);
        recruiter.setName("Jane");
        recruiter.setLastname("Doe");
        recruiter.setUsername("jane.doe");
        recruiter.setEmail("jane.doe@example.com");
        recruiter.setPhone("987654321");
        recruiter.setRegion("UK");
        recruiter.setBirthdate(LocalDate.of(1985, 8, 20));
        recruiter.setPassword("securepassword");
        recruiter.setDescription("Senior recruiter");

        assertEquals(2L, recruiter.getId());
        assertEquals("Jane", recruiter.getName());
        assertEquals("Doe", recruiter.getLastname());
        assertEquals("jane.doe", recruiter.getUsername());
        assertEquals(null, recruiter.getPhoto());
        assertEquals("jane.doe@example.com", recruiter.getEmail());
        assertEquals("987654321", recruiter.getPhone());
        assertEquals("UK", recruiter.getRegion());
        assertEquals(LocalDate.of(1985, 8, 20), recruiter.getBirthdate());
        assertEquals("securepassword", recruiter.getPassword());
        assertEquals("Senior recruiter", recruiter.getDescription());
        assertEquals(null, recruiter.getCompany());
    }
}