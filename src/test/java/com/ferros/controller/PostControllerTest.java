package com.ferros.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ferros.model.Post;
import com.ferros.model.PostStatus;
import com.ferros.repository.PostRepository;
import com.ferros.repository.gson.JsonPostRepositoryImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PostControllerTest {
    /**
     * Method under test: {@link PostController#PostController()}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        new PostController();
    }

    /**
     * Method under test: {@link PostController#PostController(PostRepository)}
     */
    @Test
    void testConstructor2() {
        assertTrue((new PostController(new JsonPostRepositoryImpl())).getAllPosts().isEmpty());
    }

    /**
     * Method under test: {@link PostController#savePost(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSavePost() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new PostController()).savePost("Not all who wander are lost");
    }

    /**
     * Method under test: {@link PostController#savePost(String)}
     */
    @Test
    void testSavePost2() {
        JsonPostRepositoryImpl jsonPostRepositoryImpl = mock(JsonPostRepositoryImpl.class);
        Post post = new Post("Not all who wander are lost", PostStatus.ACTIVE);

        when(jsonPostRepositoryImpl.save((Post) any())).thenReturn(post);
        assertSame(post, (new PostController(jsonPostRepositoryImpl)).savePost("Not all who wander are lost"));
        verify(jsonPostRepositoryImpl).save((Post) any());
    }

    /**
     * Method under test: {@link PostController#findPostById(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindPostById() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new PostController()).findPostById(1);
    }

    /**
     * Method under test: {@link PostController#findPostById(Integer)}
     */
    @Test
    void testFindPostById2() {
        assertNull((new PostController(new JsonPostRepositoryImpl())).findPostById(1));
    }

    /**
     * Method under test: {@link PostController#getAllPosts()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPosts() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new PostController()).getAllPosts();
    }

    /**
     * Method under test: {@link PostController#update(Post, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        PostController postController = new PostController();
        postController.update(new Post("Not all who wander are lost", PostStatus.ACTIVE), 1);
    }

    /**
     * Method under test: {@link PostController#update(Post, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate2() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access files outside the temporary directory (file 'src\main\resources\posts.json', permission 'write').
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        PostController postController = new PostController(new JsonPostRepositoryImpl());
        postController.update(new Post("Not all who wander are lost", PostStatus.ACTIVE), 1);
    }

    /**
     * Method under test: {@link PostController#update(Post, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate3() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new PostController()).update(mock(Post.class), 1);
    }

    /**
     * Method under test: {@link PostController#update(Post, Integer)}
     */
    @Test
    void testUpdate4() {
        PostRepository postRepository = mock(PostRepository.class);
        Post post = new Post("Not all who wander are lost", PostStatus.ACTIVE);

        when(postRepository.getById((Integer) any())).thenReturn(post);
        when(postRepository.update((Post) any())).thenReturn(new Post("Not all who wander are lost", PostStatus.ACTIVE));
        PostController postController = new PostController(postRepository);
        assertSame(post, postController.update(new Post("Not all who wander are lost", PostStatus.ACTIVE), 1));
        verify(postRepository).getById((Integer) any());
        verify(postRepository).update((Post) any());
    }

    /**
     * Method under test: {@link PostController#update(Post, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate5() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.getById((Integer) any()))
                .thenReturn(new Post("Not all who wander are lost", PostStatus.ACTIVE));
        when(postRepository.update((Post) any())).thenReturn(new Post("Not all who wander are lost", PostStatus.ACTIVE));
        PostController postController = new PostController(postRepository);

        Post post = new Post("Not all who wander are lost", PostStatus.ACTIVE);
        post.setId(1);
        postController.update(post, 1);
    }

    /**
     * Method under test: {@link PostController#update(Post, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ferros.model.Post.getId()" because "post" is null
        //       at com.ferros.controller.PostController.update(PostController.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.getById((Integer) any()))
                .thenReturn(new Post("Not all who wander are lost", PostStatus.ACTIVE));
        when(postRepository.update((Post) any())).thenReturn(new Post("Not all who wander are lost", PostStatus.ACTIVE));
        (new PostController(postRepository)).update(null, 1);
    }

    /**
     * Method under test: {@link PostController#deletePostById(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeletePostById() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new PostController()).deletePostById(1);
    }

    /**
     * Method under test: {@link PostController#deletePostById(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeletePostById2() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access files outside the temporary directory (file 'src\main\resources\posts.json', permission 'write').
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new PostController(new JsonPostRepositoryImpl())).deletePostById(1);
    }

    /**
     * Method under test: {@link PostController#deletePostById(Integer)}
     */
    @Test
    void testDeletePostById3() {
        PostRepository postRepository = mock(PostRepository.class);
        doNothing().when(postRepository).deleteById((Integer) any());
        (new PostController(postRepository)).deletePostById(1);
        verify(postRepository).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link PostController#getAllLabelsInThisPost(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllLabelsInThisPost() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new PostController()).getAllLabelsInThisPost(123);
    }

    /**
     * Method under test: {@link PostController#getAllLabelsInThisPost(Integer)}
     */
    @Test
    void testGetAllLabelsInThisPost2() {
        assertNull((new PostController()).getAllLabelsInThisPost(null));
    }

    /**
     * Method under test: {@link PostController#saveNewLabelToPost(Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveNewLabelToPost() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new PostController()).saveNewLabelToPost(1, 1);
    }

    /**
     * Method under test: {@link PostController#saveNewLabelToPost(Integer, Integer)}
     */
    @Test
    void testSaveNewLabelToPost2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new PostController()).saveNewLabelToPost(null, 1);
    }
}

