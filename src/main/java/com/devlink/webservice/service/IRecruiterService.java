package com.devlink.webservice.service;
import com.devlink.webservice.entities.Recruiter;
import com.devlink.webservice.entities.Company;

import java.util.List;

public interface IRecruiterService extends CrudService<Recruiter> {

    // Obtener todos los reclutadores de una empresa
    List<Recruiter> getByCompany(Company company) throws Exception;

    // Obtener todos los reclutadores en una ubicación específica
    //List<Recruiter> getByLocation(String location) throws Exception;

    // Actualizar la información de un reclutador
    Recruiter updateRecruiter(Long id, Recruiter updatedRecruiter) throws Exception;

    // Otros métodos específicos según las necesidades de tu aplicación
}