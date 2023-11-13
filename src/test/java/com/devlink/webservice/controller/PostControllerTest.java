package com.devlink.webservice.controller;
import com.devlink.webservice.controller.PostController;
import com.devlink.webservice.entities.Post;
import com.devlink.webservice.service.IPostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
class PostControllerTest {

    @Mock
    private IPostService postService;

    @InjectMocks
    private PostController postController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCreatePost() {
        // Arrange
        Post post = new Post();
        try {
            when(postService.save(post)).thenReturn(post);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<Post> response = postController.createPost(post);

        // Assert
        try {
            verify(postService, times(1)).save(post);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.CREATED);
    }

    @Test
    void testGetAllPosts() {
        // Arrange
        List<Post> posts = Arrays.asList(new Post(), new Post());
        try {
            when(postService.getAll()).thenReturn(posts);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<List<Post>> response = postController.getAllPosts();

        // Assert
        try {
            verify(postService, times(1)).getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.OK);

    }

    @Test
    void testGetPostById() {
        // Arrange
        Long postId = 1L;
        Post post = new Post();
        try {
            when(postService.getById(postId)).thenReturn(Optional.of(post));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<Post> response = postController.getPostById(postId);

        // Assert
        try {
            verify(postService, times(1)).getById(postId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.OK);

    }

    @Test
    void testGetPostByIdNotFound() {
        // Arrange
        Long postId = 1L;
        try {
            when(postService.getById(postId)).thenReturn(Optional.empty());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Act
        ResponseEntity<Post> response = postController.getPostById(postId);

        // Assert
        try {
            verify(postService, times(1)).getById(postId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.NOT_FOUND);

    }

    @Test
    void testDeletePost() {
        // Arrange
        Long postId = 1L;

        // Act
        ResponseEntity<Void> response = postController.deletePost(postId);

        // Assert
        try {
            verify(postService, times(1)).delete(postId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert(response.getStatusCode() == HttpStatus.NO_CONTENT);
    }
}