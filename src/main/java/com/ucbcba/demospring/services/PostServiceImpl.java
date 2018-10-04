package com.ucbcba.demospring.services;

import com.ucbcba.demospring.entities.Post;
import com.ucbcba.demospring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    public PostRepository postRepository;


    @Autowired
    //@Qualifier(value = "postRepository")
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Iterable<Post> listAllPosts() {
        return postRepository.findAll();
    }
    @Override
    public Post getPostById(Integer id) {
        Optional<Post> opt;
        opt=postRepository.findById(id);
        return opt.get();
    }
    @Override
    public void savePost(Post post)
    {
        postRepository.save(post);
    }
    @Override
    public void deletePost(Integer id)
    {
        postRepository.deleteById(id);
    }

}
