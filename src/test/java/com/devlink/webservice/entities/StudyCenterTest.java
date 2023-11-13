package com.devlink.webservice.entities;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudyCenterTest {

    @Test
    void testCreateStudyCenter() {
        StudyCenter studyCenter = new StudyCenter();
        studyCenter.setId(1L);
        studyCenter.setName("University of Example");
        studyCenter.setLocation("City, Country");

        assertEquals(1L, studyCenter.getId());
        assertEquals("University of Example", studyCenter.getName());
        assertEquals("City, Country", studyCenter.getLocation());
    }

    @Test
    void testCreateStudyCenterWithEducations() {
        StudyCenter studyCenter = new StudyCenter();
        studyCenter.setId(2L);
        studyCenter.setName("College of Example");
        studyCenter.setLocation("Town, Country");

        Education education1 = new Education();
        education1.setId(1L);
        education1.setDegree("Bachelor's Degree");

        Education education2 = new Education();
        education2.setId(2L);
        education2.setDegree("Master's Degree");

        studyCenter.setEducations(List.of(education1, education2));

        assertEquals(2L, studyCenter.getId());
        assertEquals("College of Example", studyCenter.getName());
        assertEquals("Town, Country", studyCenter.getLocation());

        assertNotNull(studyCenter.getEducations());
        assertEquals(2, studyCenter.getEducations().size());

        Education firstEducation = studyCenter.getEducations().get(0);
        assertEquals(1L, firstEducation.getId());
        assertEquals("Bachelor's Degree", firstEducation.getDegree());

        Education secondEducation = studyCenter.getEducations().get(1);
        assertEquals(2L, secondEducation.getId());
        assertEquals("Master's Degree", secondEducation.getDegree());
    }
}