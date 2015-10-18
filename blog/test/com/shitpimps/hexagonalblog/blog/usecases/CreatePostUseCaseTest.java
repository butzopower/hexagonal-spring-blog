package com.shitpimps.hexagonalblog.blog.usecases;

import com.shitpimps.hexagonalblog.blog.repositories.PostRepository;
import com.shitpimps.hexagonalblog.blog.values.Post;
import com.shitpimps.hexagonalblog.blogtestsupport.doubles.FakePostRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CreatePostUseCaseTest {
    private PostRepository fakePostRepository;
    private Post createdPost;
    private Post presentedPost;

    @Before
    public void setup() {
        fakePostRepository = new FakePostRepository();
    }

    @Test
    public void testPersistsPost() throws Exception {
        Post post = new Post(null, "Post Title", "Post Content");
        CreatePostUseCase createPostUseCase = new CreatePostUseCase(
                fakePostRepository,
                new CreatePostUseCaseObserver() {
                    @Override
                    public void postCreated(Post post) {
                        createdPost = post;
                    }
                },
                post
        );

        createPostUseCase.execute();

        String postId = createdPost.getId();

        PresentPostUseCase presentPostUseCase = new PresentPostUseCase(
                fakePostRepository,
                new PresentPostUseCaseObserver() {
                    @Override
                    public void postPresented(Post post) {
                        presentedPost = post;
                    }
                },
                postId
        );

        presentPostUseCase.execute();

        assertThat(presentedPost.getTitle(), equalTo("Post Title"));
        assertThat(presentedPost.getContent(), equalTo("Post Content"));
    }
}

