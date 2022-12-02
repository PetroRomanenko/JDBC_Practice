package com.ferros.controller;

import com.ferros.model.Label;
import com.ferros.model.Post;
import com.ferros.model.PostStatus;
import com.ferros.repository.PostRepository;
import com.ferros.repository.database.SqlLabelRepositoryImpl;
import com.ferros.repository.database.SqlPostRepositoryImpl;
import com.ferros.repository.gson.JsonPostRepositoryImpl;

import java.util.Date;
import java.util.List;

public class PostController {
    private SqlPostRepositoryImpl postRepo = new SqlPostRepositoryImpl();

    private  PostRepository postRepository = new SqlPostRepositoryImpl();

    public PostController() {
    }

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post savePost(String content){

            Post post = new Post(content, PostStatus.ACTIVE);
            return postRepository.save(post);


    }

    public Post findPostById(Integer id){
        return postRepository.getById(id);
    }

    public List<Post> getAllPosts(){
        return postRepository.getAll();
    }

    public Post update(Post post, Integer id){

        postRepository.update(post);
        return  post;
    }

    public void deletePostById(Integer id){
        postRepository.deleteById(id);
    }

    public List<Label> getAllLabelsInThisPost(Post post, SqlPostRepositoryImpl sqlPostRepository){
        if (post!=null){
           return sqlPostRepository.getAllLabelsInPost(post);
        }
        return null;
    }

}
