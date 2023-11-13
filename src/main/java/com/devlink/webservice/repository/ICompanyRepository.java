package com.devlink.webservice.repository;
import com.devlink.webservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByLocation(String location);

    //List<Company> findByIndustry(String industry);

    // Puedes agregar otros métodos de consulta según tus necesidades

}