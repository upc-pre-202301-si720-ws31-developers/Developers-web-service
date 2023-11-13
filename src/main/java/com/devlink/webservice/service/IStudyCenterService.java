package com.devlink.webservice.service;


import com.devlink.webservice.entities.StudyCenter;
import com.devlink.webservice.entities.Education;

import java.util.List;

public interface IStudyCenterService extends CrudService<StudyCenter> {

    // Obtener todos los centros de estudio de una ubicación específica
    List<StudyCenter> getByLocation(String location) throws Exception;

    // Obtener todos los centros de estudio que ofrecen una especialidad específica
    //List<StudyCenter> getBySpecialization(String specialization) throws Exception;

    // Obtener todas las educaciones asociadas a un centro de estudio

    // Actualizar la información de un centro de estudio
    StudyCenter updateStudyCenter(Long id, StudyCenter updatedStudyCenter) throws Exception;

    // Otros métodos específicos según las necesidades de tu aplicación
}
