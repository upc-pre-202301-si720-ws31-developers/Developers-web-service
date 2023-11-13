package com.devlink.webservice.repository;
import com.devlink.webservice.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IDeveloperRepository extends JpaRepository<Developer, Long> {

    Optional<Developer> findByUsername(String username);

    Optional<Developer> findByEmail(String email);

    // Puedes agregar otros métodos de consulta según tus necesidades

}