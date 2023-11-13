package com.devlink.webservice.repository;
import com.devlink.webservice.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.devlink.webservice.entities.Developer;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

    //List<Post> findByDeveloper(Developer developer);

    //List<Post> findByCategory(String category);

    //List<Post> findByTitleContainingOrContentContaining(String title, String content);

    // Puedes agregar otros métodos de consulta según tus necesidades

}