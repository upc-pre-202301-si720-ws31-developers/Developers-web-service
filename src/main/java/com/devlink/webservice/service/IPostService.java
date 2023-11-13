package com.devlink.webservice.service;
import com.devlink.webservice.entities.Post;
import com.devlink.webservice.entities.Developer;

import java.util.List;

public interface IPostService extends CrudService<Post> {

    // Obtener todos los posts de un desarrollador
    //List<Post> getByDeveloper(Developer developer) throws Exception;

    // Obtener todos los posts en una categoría específica
    //List<Post> getByCategory(String category) throws Exception;

    // Obtener todos los posts que contienen una palabra clave en el título o contenido
    //List<Post> searchByKeyword(String keyword) throws Exception;

// Otros métodos específicos según las necesidades de tu aplicación
}