package com.devlink.webservice.repository;
import com.devlink.webservice.entities.Education;
import com.devlink.webservice.entities.Developer;
import com.devlink.webservice.entities.StudyCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEducationRepository extends JpaRepository<Education, Long> {

    List<Education> findByDeveloper(Developer developer);

    List<Education> findByStudyCenter(StudyCenter studyCenter);

    List<Education> findByFieldOfStudy(String fieldOfStudy);

    // Puedes agregar otros métodos de consulta según tus necesidades

}