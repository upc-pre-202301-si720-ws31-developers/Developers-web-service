package com.devlink.webservice.service;

import com.devlink.webservice.entities.Company;

import java.util.List;
public interface ICompanyService extends CrudService<Company> {

    // Buscar una empresa por nombre
    //Optional<Company> getByName(String name) throws Exception;

    // Obtener todas las empresas en una ubicación específica
    List<Company> getByLocation(String location) throws Exception;

    // Actualizar la información de una empresa
    Company updateCompany(Long id, Company updatedCompany) throws Exception;

    // Agregar un reclutador a una empresa
    //Company addRecruiter(Long companyId, Long recruiterId) throws Exception;

    // Eliminar un reclutador de una empresa
    //Company removeRecruiter(Long companyId, Long recruiterId) throws Exception;

    // Otros métodos específicos según las necesidades de tu aplicación
}
