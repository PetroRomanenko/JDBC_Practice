package com.ferros.view;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ferros.model.Label;
import com.ferros.model.Post;
import com.ferros.model.PostStatus;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PostViewTest {
    /**
     * Method under test: {@link PostView#createPost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePost() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        PostView postView = null;

        // Act
        postView.createPost();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link PostView#findPostById()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindPostById() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        PostView postView = null;

        // Act
        postView.findPostById();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link PostView#showAllPosts()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testShowAllPosts() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new PostView()).showAllPosts();
    }

    /**
     * Method under test: {@link PostView#updatePost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdatePost() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        PostView postView = null;

        // Act
        postView.updatePost();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link PostView#deletePostByID()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeletePostByID() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        PostView postView = null;

        // Act
        postView.deletePostByID();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link PostView#showMenuMassage()}
     */
    @Test
    void testShowMenuMassage() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PostView.CRUDMassage
        //     PostView.controller
        //     PostView.line
        //     PostView.scanner

        (new PostView()).showMenuMassage();
    }

    /**
     * Method under test: {@link PostView#menuChoice()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMenuChoice() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        PostView postView = null;

        // Act
        postView.menuChoice();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link PostView#printPostList(List)}
     */
    @Test
    void testPrintPostList() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PostView.CRUDMassage
        //     PostView.controller
        //     PostView.line
        //     PostView.scanner

        PostView postView = new PostView();
        postView.printPostList(new ArrayList<>());
    }

    /**
     * Method under test: {@link PostView#printPostList(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrintPostList2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Long.longValue()" because the return value of "com.ferros.model.Post.getCreated()" is null
        //       at com.ferros.view.PostView.printPost(PostView.java:172)
        //       at com.ferros.view.PostView.printPostList(PostView.java:162)
        //   See https://diff.blue/R013 to resolve this issue.

        PostView postView = new PostView();

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(new Post("Not all who wander are lost", PostStatus.ACTIVE));
        postView.printPostList(postList);
    }

    /**
     * Method under test: {@link PostView#printPostList(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrintPostList3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Iterable.iterator()" because "iterable" is null
        //       at com.ferros.view.LabelView.printList(LabelView.java:108)
        //       at com.ferros.view.PostView.printPost(PostView.java:179)
        //       at com.ferros.view.PostView.printPostList(PostView.java:162)
        //   See https://diff.blue/R013 to resolve this issue.

        PostView postView = new PostView();

        Post post = new Post("Not all who wander are lost", PostStatus.ACTIVE);
        post.setCreated(1L);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post);
        postView.printPostList(postList);
    }

    /**
     * Method under test: {@link PostView#printPostList(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrintPostList4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Long.longValue()" because the return value of "com.ferros.model.Post.getCreated()" is null
        //       at com.ferros.view.PostView.printPost(PostView.java:172)
        //       at com.ferros.view.PostView.printPostList(PostView.java:162)
        //   See https://diff.blue/R013 to resolve this issue.

        PostView postView = new PostView();
        Post post = mock(Post.class);
        doNothing().when(post).setCreated((Long) any());
        post.setCreated(0L);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(new Post("Not all who wander are lost", PostStatus.ACTIVE));
        postList.add(post);
        postView.printPostList(postList);
    }

    /**
     * Method under test: {@link PostView#printPostList(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrintPostList5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ferros.model.Post.getId()" because "post" is null
        //       at com.ferros.view.PostView.printPost(PostView.java:170)
        //       at com.ferros.view.PostView.printPostList(PostView.java:162)
        //   See https://diff.blue/R013 to resolve this issue.

        PostView postView = new PostView();
        Post post = mock(Post.class);
        doNothing().when(post).setCreated((Long) any());
        post.setCreated(0L);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(null);
        postList.add(post);
        postView.printPostList(postList);
    }

    /**
     * Method under test: {@link PostView#printPostList(List)}
     */
    @Test
    void testPrintPostList6() {
        PostView postView = new PostView();
        Post post = mock(Post.class);
        when(post.getStatus()).thenReturn(PostStatus.ACTIVE);
        when(post.getId()).thenReturn(1);
        when(post.getCreated()).thenReturn(1L);
        when(post.getUpdated()).thenReturn(1L);
        when(post.getContent()).thenReturn("Not all who wander are lost");
        when(post.getLabels()).thenReturn(new ArrayList<>());
        doNothing().when(post).setCreated((Long) any());
        post.setCreated(0L);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(new Post(1, "Not all who wander are lost", 1L, PostStatus.ACTIVE, new ArrayList<>()));
        postList.add(post);
        postView.printPostList(postList);
        verify(post).getStatus();
        verify(post).getId();
        verify(post).getCreated();
        verify(post, atLeast(1)).getUpdated();
        verify(post).getContent();
        verify(post).getLabels();
        verify(post).setCreated((Long) any());
    }

    /**
     * Method under test: {@link PostView#printPostList(List)}
     */
    @Test
    void testPrintPostList7() {
        PostView postView = new PostView();
        Post post = mock(Post.class);
        when(post.getStatus()).thenReturn(PostStatus.ACTIVE);
        when(post.getId()).thenReturn(1);
        when(post.getCreated()).thenReturn(1L);
        when(post.getUpdated()).thenReturn(1L);
        when(post.getContent()).thenReturn("Not all who wander are lost");
        when(post.getLabels()).thenReturn(new ArrayList<>());
        doNothing().when(post).setCreated((Long) any());
        post.setCreated(0L);

        ArrayList<Label> labelList = new ArrayList<>();
        labelList.add(new Label("Labels in this post: "));
        Post e = new Post(1, "Not all who wander are lost", 1L, PostStatus.ACTIVE, labelList);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(e);
        postList.add(post);
        postView.printPostList(postList);
        verify(post).getStatus();
        verify(post).getId();
        verify(post).getCreated();
        verify(post, atLeast(1)).getUpdated();
        verify(post).getContent();
        verify(post).getLabels();
        verify(post).setCreated((Long) any());
    }

    /**
     * Method under test: {@link PostView#printPost(Post, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrintPost() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Long.longValue()" because the return value of "com.ferros.model.Post.getCreated()" is null
        //       at com.ferros.view.PostView.printPost(PostView.java:172)
        //   See https://diff.blue/R013 to resolve this issue.

        PostView postView = new PostView();
        postView.printPost(new Post("Not all who wander are lost", PostStatus.ACTIVE), "Not all who wander are lost");
    }

    /**
     * Method under test: {@link PostView#printPost(Post, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrintPost2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Long.longValue()" because the return value of "com.ferros.model.Post.getCreated()" is null
        //       at com.ferros.view.PostView.printPost(PostView.java:172)
        //   See https://diff.blue/R013 to resolve this issue.

        PostView postView = new PostView();
        postView.printPost(new Post("Not all who wander are lost", PostStatus.ACTIVE), null);
    }

    /**
     * Method under test: {@link PostView#printPost(Post, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrintPost3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Iterable.iterator()" because "iterable" is null
        //       at com.ferros.view.LabelView.printList(LabelView.java:108)
        //       at com.ferros.view.PostView.printPost(PostView.java:179)
        //   See https://diff.blue/R013 to resolve this issue.

        PostView postView = new PostView();

        Post post = new Post("Not all who wander are lost", PostStatus.ACTIVE);
        post.setCreated(1L);
        postView.printPost(post, "Not all who wander are lost");
    }

    /**
     * Method under test: {@link PostView#printPost(Post, String)}
     */
    @Test
    void testPrintPost4() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PostView.CRUDMassage
        //     PostView.controller
        //     PostView.line
        //     PostView.scanner

        PostView postView = new PostView();

        Post post = new Post(1, "Not all who wander are lost", 1L, PostStatus.ACTIVE, new ArrayList<>());
        post.setCreated(1L);
        postView.printPost(post, "Not all who wander are lost");
    }

    /**
     * Method under test: {@link PostView#printPost(Post, String)}
     */
    @Test
    void testPrintPost5() {
        PostView postView = new PostView();
        Post post = mock(Post.class);
        when(post.getStatus()).thenReturn(PostStatus.ACTIVE);
        when(post.getId()).thenReturn(1);
        when(post.getCreated()).thenReturn(1L);
        when(post.getUpdated()).thenReturn(1L);
        when(post.getContent()).thenReturn("Not all who wander are lost");
        when(post.getLabels()).thenReturn(new ArrayList<>());
        doNothing().when(post).setCreated((Long) any());
        post.setCreated(1L);
        postView.printPost(post, "Not all who wander are lost");
        verify(post).getStatus();
        verify(post).getId();
        verify(post).getCreated();
        verify(post, atLeast(1)).getUpdated();
        verify(post).getContent();
        verify(post).getLabels();
        verify(post).setCreated((Long) any());
    }

    /**
     * Method under test: {@link PostView#printPost(Post, String)}
     */
    @Test
    void testPrintPost6() {
        PostView postView = new PostView();

        ArrayList<Label> labelList = new ArrayList<>();
        labelList.add(new Label("Labels in this post: "));
        Post post = mock(Post.class);
        when(post.getStatus()).thenReturn(PostStatus.ACTIVE);
        when(post.getId()).thenReturn(1);
        when(post.getCreated()).thenReturn(1L);
        when(post.getUpdated()).thenReturn(1L);
        when(post.getContent()).thenReturn("Not all who wander are lost");
        when(post.getLabels()).thenReturn(labelList);
        doNothing().when(post).setCreated((Long) any());
        post.setCreated(1L);
        postView.printPost(post, "Not all who wander are lost");
        verify(post).getStatus();
        verify(post).getId();
        verify(post).getCreated();
        verify(post, atLeast(1)).getUpdated();
        verify(post).getContent();
        verify(post).getLabels();
        verify(post).setCreated((Long) any());
    }

    /**
     * Method under test: {@link PostView#printPost(Post, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrintPost7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ferros.model.Label.getId()" because "label" is null
        //       at com.ferros.view.LabelView.printLabel(LabelView.java:117)
        //       at com.ferros.view.LabelView.printList(LabelView.java:109)
        //       at com.ferros.view.PostView.printPost(PostView.java:179)
        //   See https://diff.blue/R013 to resolve this issue.

        PostView postView = new PostView();

        ArrayList<Label> labelList = new ArrayList<>();
        labelList.add(null);
        Post post = mock(Post.class);
        when(post.getStatus()).thenReturn(PostStatus.ACTIVE);
        when(post.getId()).thenReturn(1);
        when(post.getCreated()).thenReturn(1L);
        when(post.getUpdated()).thenReturn(1L);
        when(post.getContent()).thenReturn("Not all who wander are lost");
        when(post.getLabels()).thenReturn(labelList);
        doNothing().when(post).setCreated((Long) any());
        post.setCreated(1L);
        postView.printPost(post, "Not all who wander are lost");
    }
}

