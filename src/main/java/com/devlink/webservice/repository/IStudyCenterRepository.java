package com.devlink.webservice.repository;
import com.devlink.webservice.entities.StudyCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudyCenterRepository extends JpaRepository<StudyCenter, Long> {

    List<StudyCenter> findByLocation(String location);

    //List<StudyCenter> find(String specialization);

}