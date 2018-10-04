package com.ucbcba.demospring.services;

import com.ucbcba.demospring.entities.Post;

import java.util.Optional;

public interface PostService {

    Iterable<Post> listAllPosts();
    Post getPostById(Integer id);
    void savePost(Post post);
    void deletePost(Integer id);
}
