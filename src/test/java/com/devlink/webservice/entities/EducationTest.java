package com.devlink.webservice.entities;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EducationTest {

    @Test
    void testCreateEducation() {
        Developer developer = new Developer();
        developer.setId(1L);

        StudyCenter studyCenter = new StudyCenter();
        studyCenter.setId(1L);

        Education education = new Education();
        education.setId(1L);
        education.setDeveloper(developer);
        education.setStudyCenter(studyCenter);
        education.setDegree("Bachelor's Degree");
        education.setSchool("University of XYZ");
        education.setFieldOfStudy("Computer Science");
        education.setStartDate(LocalDate.of(2015, 9, 1));
        education.setEndDate(LocalDate.of(2019, 5, 1));

        assertEquals(1L, education.getId());
        assertEquals(developer, education.getDeveloper());
        assertEquals(studyCenter, education.getStudyCenter());
        assertEquals("Bachelor's Degree", education.getDegree());
        assertEquals("University of XYZ", education.getSchool());
        assertEquals("Computer Science", education.getFieldOfStudy());
        assertEquals(LocalDate.of(2015, 9, 1), education.getStartDate());
        assertEquals(LocalDate.of(2019, 5, 1), education.getEndDate());
    }

    @Test
    void testCreateEducationWithoutEndDate() {
        Developer developer = new Developer();
        developer.setId(1L);

        StudyCenter studyCenter = new StudyCenter();
        studyCenter.setId(1L);

        Education education = new Education();
        education.setId(1L);
        education.setDeveloper(developer);
        education.setStudyCenter(studyCenter);
        education.setDegree("Master's Degree");
        education.setSchool("Another University");
        education.setFieldOfStudy("Information Technology");
        education.setStartDate(LocalDate.of(2020, 9, 1));

        assertEquals(1L, education.getId());
        assertEquals(developer, education.getDeveloper());
        assertEquals(studyCenter, education.getStudyCenter());
        assertEquals("Master's Degree", education.getDegree());
        assertEquals("Another University", education.getSchool());
        assertEquals("Information Technology", education.getFieldOfStudy());
        assertEquals(LocalDate.of(2020, 9, 1), education.getStartDate());
        assertNull(education.getEndDate());
    }
}