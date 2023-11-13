package com.devlink.webservice.service.impl;
import com.devlink.webservice.entities.Post;
import com.devlink.webservice.entities.Developer;
import com.devlink.webservice.repository.IPostRepository;
import com.devlink.webservice.service.IPostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements IPostService {

    private final IPostRepository postRepository;

    public PostServiceImpl(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public Post save(Post post) throws Exception {
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getAll() throws Exception {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getById(Long id) throws Exception {
        return postRepository.findById(id);
    }
/*
    @Override
    public List<Post> getByDeveloper(Developer developer) throws Exception {
        return postRepository.findByDeveloper(developer);
    }

    @Override
    public List<Post> getByCategory(String category) throws Exception {
        return postRepository.findByCategory(category);
    }

    @Override
    public List<Post> searchByKeyword(String keyword) throws Exception {
        return postRepository.findByTitleContainingOrContentContaining(keyword, keyword);
    }

 */


}
