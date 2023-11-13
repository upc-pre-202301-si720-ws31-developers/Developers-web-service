package com.devlink.webservice.entities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    void testCreatePost() {
        Recruiter recruiter = new Recruiter();
        recruiter.setId(1L);

        Post post = new Post();
        post.setId(1L);
        post.setBannerPhoto("banner.jpg");
        post.setTitle("Job Opening for Software Developer");
        post.setDescription("We are hiring a skilled software developer.");
        post.setAmount("Competitive salary");
        post.setVisible(true);
        post.setRecruiter(recruiter);

        assertEquals(1L, post.getId());
        assertEquals("banner.jpg", post.getBannerPhoto());
        assertEquals("Job Opening for Software Developer", post.getTitle());
        assertEquals("We are hiring a skilled software developer.", post.getDescription());
        assertEquals("Competitive salary", post.getAmount());
        assertTrue(post.isVisible());
        assertEquals(recruiter, post.getRecruiter());
    }

    @Test
    void testCreatePostWithoutVisibility() {
        Recruiter recruiter = new Recruiter();
        recruiter.setId(1L);

        Post post = new Post();
        post.setId(2L);
        post.setBannerPhoto("another_banner.jpg");
        post.setTitle("Exciting Opportunity for Web Developer");
        post.setDescription("Join our team as a web developer.");
        post.setAmount("Salary based on experience");
        post.setRecruiter(recruiter);

        assertEquals(2L, post.getId());
        assertEquals("another_banner.jpg", post.getBannerPhoto());
        assertEquals("Exciting Opportunity for Web Developer", post.getTitle());
        assertEquals("Join our team as a web developer.", post.getDescription());
        assertEquals("Salary based on experience", post.getAmount());
        assertFalse(post.isVisible());
        assertEquals(recruiter, post.getRecruiter());
    }
}