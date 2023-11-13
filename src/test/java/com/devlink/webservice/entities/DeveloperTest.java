package com.devlink.webservice.entities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import com.devlink.webservice.entities.Developer;
class DeveloperTest {
    @Test
    void testCreateDeveloper() {
        Developer developer = new Developer();
        developer.setId(1L);
        developer.setName("John");
        developer.setLastname("Doe");
        developer.setUsername("johndoe");
        developer.setPhoto("profile.jpg");
        developer.setEmail("john.doe@example.com");
        developer.setPhone("123456789");
        developer.setRegion("US");
        developer.setBirthdate(LocalDate.of(1990, 1, 1));
        developer.setPassword("securePassword");
        developer.setDescription("Java Developer");

        assertEquals(1L, developer.getId());
        assertEquals("John", developer.getName());
        assertEquals("Doe", developer.getLastname());
        assertEquals("johndoe", developer.getUsername());
        assertEquals("profile.jpg", developer.getPhoto());
        assertEquals("john.doe@example.com", developer.getEmail());
        assertEquals("123456789", developer.getPhone());
        assertEquals("US", developer.getRegion());
        assertEquals(LocalDate.of(1990, 1, 1), developer.getBirthdate());
        assertEquals("securePassword", developer.getPassword());
        assertEquals("Java Developer", developer.getDescription());
    }

    @Test
    void testCreateDeveloperWithoutOptionalFields() {
        Developer developer = new Developer();
        developer.setId(1L);
        developer.setName("John");
        developer.setLastname("Doe");
        developer.setUsername("johndoe");
        developer.setEmail("john.doe@example.com");
        developer.setPhone("123456789");
        developer.setBirthdate(LocalDate.of(1990, 1, 1));
        developer.setPassword("securePassword");

        assertEquals(1L, developer.getId());
        assertEquals("John", developer.getName());
        assertEquals("Doe", developer.getLastname());
        assertEquals("johndoe", developer.getUsername());
        assertNull(developer.getPhoto());
        assertEquals("john.doe@example.com", developer.getEmail());
        assertEquals("123456789", developer.getPhone());
        assertNull(developer.getRegion());
        assertEquals(LocalDate.of(1990, 1, 1), developer.getBirthdate());
        assertEquals("securePassword", developer.getPassword());
        assertNull(developer.getDescription());
    }

}