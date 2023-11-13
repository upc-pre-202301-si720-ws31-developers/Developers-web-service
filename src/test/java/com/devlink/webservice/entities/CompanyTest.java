package com.devlink.webservice.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
class CompanyTest {
    @Test
    void testCreateCompany() {
        Company company = new Company();
        company.setId(1L);
        company.setName("Test Company");
        company.setLocation("Test Location");

        List<Recruiter> recruiters = new ArrayList<>();
        Recruiter recruiter1 = new Recruiter();
        recruiter1.setId(1L);
        recruiter1.setName("Recruiter 1");

        Recruiter recruiter2 = new Recruiter();
        recruiter2.setId(2L);
        recruiter2.setName("Recruiter 2");

        recruiters.add(recruiter1);
        recruiters.add(recruiter2);

        company.setRecruiters(recruiters);

        assertEquals(1L, company.getId());
        assertEquals("Test Company", company.getName());
        assertEquals("Test Location", company.getLocation());
        assertNotNull(company.getRecruiters());
        assertEquals(2, company.getRecruiters().size());
    }

    @Test
    void testCreateCompanyWithoutRecruiters() {
        Company company = new Company();
        company.setId(1L);
        company.setName("Test Company");
        company.setLocation("Test Location");

        assertEquals(1L, company.getId());
        assertEquals("Test Company", company.getName());
        assertEquals("Test Location", company.getLocation());

    }

    @Test
    void testSetRecruiters() {
        Company company = new Company();
        List<Recruiter> recruiters = new ArrayList<>();
        company.setRecruiters(recruiters);

        assertNotNull(company.getRecruiters());
        assertEquals(0, company.getRecruiters().size());

        Recruiter recruiter = new Recruiter();
        recruiters.add(recruiter);

        assertEquals(1, company.getRecruiters().size());
    }
}