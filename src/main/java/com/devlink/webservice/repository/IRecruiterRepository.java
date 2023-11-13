package com.devlink.webservice.repository;
import com.devlink.webservice.entities.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.devlink.webservice.entities.Company;

@Repository
public interface IRecruiterRepository extends JpaRepository<Recruiter, Long> {

    List<Recruiter> findByCompany(Company company);

    //List<Recruiter> findByLocation(String location);

    // Puedes agregar otros métodos de consulta según tus necesidades

}