package com.devlink.webservice.service;
import com.devlink.webservice.entities.Developer;

import java.util.List;
import java.util.Optional;

public interface IDeveloperService extends CrudService<Developer> {

    // Buscar un desarrollador por nombre de usuario
    Optional<Developer> getByUsername(String username) throws Exception;

    // Buscar desarrolladores por región
    //List<Developer> getByRegion(String region) throws Exception;

    // Cambiar la contraseña de un desarrollador
    //Developer changePassword(Long developerId, String newPassword) throws Exception;

    // Actualizar la información de un desarrollador
    Developer updateDeveloper(Long id, Developer updatedDeveloper) throws Exception;

    // Otros métodos específicos según las necesidades de tu aplicación
}
