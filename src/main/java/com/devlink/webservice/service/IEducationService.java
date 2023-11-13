package com.devlink.webservice.service;
import com.devlink.webservice.entities.Education;
import com.devlink.webservice.entities.Developer;
import com.devlink.webservice.entities.StudyCenter;

import java.util.List;

public interface IEducationService extends CrudService<Education> {

    // Obtener todas las educaciones de un desarrollador
    List<Education> getByDeveloper(Developer developer) throws Exception;

    // Obtener todas las educaciones de un centro de estudio
    List<Education> getByStudyCenter(StudyCenter studyCenter) throws Exception;

    // Obtener todas las educaciones en un campo de estudio específico
    List<Education> getByFieldOfStudy(String fieldOfStudy) throws Exception;

    // Actualizar la información de una educación
    Education updateEducation(Long id, Education updatedEducation) throws Exception;

    // Otros métodos específicos según las necesidades de tu aplicación
}