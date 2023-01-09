package com.ferros.repository.jdbc;

import com.ferros.model.Label;
import com.ferros.model.Post;
import com.ferros.model.PostStatus;

public class RunnerForTest {
    public static void main(String[] args) {
//        JdbcLabelRepositoryImpl reL = new JdbcLabelRepositoryImpl();
//        Label label = new Label();
//        label.setName("New Label");
//        Label savedLabel = reL.save(label);
//        System.out.println(savedLabel);

        JdbcPostRepositoryImpl postRepository= new JdbcPostRepositoryImpl();
        Post post = new Post("New Post", PostStatus.ACTIVE);
        postRepository.save(post);
        System.out.println(postRepository.getById(post.getId()));

    }
}
