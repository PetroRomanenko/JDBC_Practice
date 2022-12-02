package com.ferros.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ferros.model.Label;
import com.ferros.model.Post;
import com.ferros.model.PostStatus;
import com.ferros.repository.PostRepository;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JsonPostRepositoryImpl implements PostRepository {

    private final Gson gson = new Gson();
    private final String POST_FILE_LOCATION = "src/main/resources/posts.json";
    private final Path POST_FILE_PATH = Path.of(POST_FILE_LOCATION);

    private List<Post> getAllPostInternal() {
        try {
            String jsonString = Files.readString(POST_FILE_PATH);
            Type typeOfList = new TypeToken<ArrayList<Post>>() {
            }.getType();
            return gson.fromJson(jsonString, typeOfList);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private void writePostsToFile(List<Post> posts) {
        try {
            String postsJson = gson.toJson(posts);
            Files.write(POST_FILE_PATH, postsJson.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to read posts.json");
        }
    }

    private Integer generateId(List<Post> posts) {
        Post postWithMaxId = posts.stream().max(Comparator.comparing(Post::getId)).orElse(null);
        return Objects.nonNull(postWithMaxId) ? postWithMaxId.getId() + 1 : 1;
    }

    @Override
    public Post getById(Integer id) {
        List<Post> postList = getAllPostInternal();
        return postList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return getAllPostInternal();
    }

    private Long getCurrentTime(Post post) {
        return new Date().getTime();
    }

    @Override
    public Post save(Post post) {
        List<Post> postList = getAllPostInternal();
        Integer newId = generateId(postList);

        post.setId(newId);
        post.setCreated(getCurrentTime(post));

        //Change
        post.setUpdated(getCurrentTime(post) * 2);

        postList.add(post);

        writePostsToFile(postList);
        return post;
    }

    public Post addLabelToPostAndUpdateJson(Post post, Integer id) {
        List<Post> postList = getAllPostInternal();
        List<Label> labelList = getLabelsForPost(id);
        post.setLabels(labelList);
        writePostsToFile(postList);
        return post;
    }

    private List<Label> getLabelsForPost(Integer id) {
        JsonLabelRepositoryImpl repository = new JsonLabelRepositoryImpl();
        Label label = repository.getById(id);
        List<Label> labelList = new ArrayList<>();
        labelList.add(label);
        return labelList;
    }

    @Override
    public Post update(Post post) {
        List<Post> postList = getAllPostInternal();
        for (Post postItr : postList) {
            if (postItr.getId().equals(post.getId())) {
                postItr.setContent(post.getContent());
                postItr.setUpdated(getCurrentTime(post));
                postItr.setStatus(PostStatus.UNDER_REVIEW);
            }
        }
        writePostsToFile(postList);
        return post;
    }

    @Override
    public void deleteById(Integer id) {
        List<Post> postList = getAllPostInternal();
        postList.removeIf(post -> post.getId().equals(id));
        writePostsToFile(postList);

    }
}



