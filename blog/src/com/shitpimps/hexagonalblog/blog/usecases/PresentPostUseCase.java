package com.shitpimps.hexagonalblog.blog.usecases;

import com.shitpimps.hexagonalblog.blog.repositories.PostRepository;
import com.shitpimps.hexagonalblog.blog.values.Post;

public class PresentPostUseCase {

    private PostRepository postRepository;
    private PresentPostUseCaseObserver observer;
    private String postId;

    public PresentPostUseCase(PostRepository postRepository, PresentPostUseCaseObserver observer, String postId) {
        this.postRepository = postRepository;
        this.observer = observer;
        this.postId = postId;
    }

    public void execute() {
        Post post = postRepository.get(postId);
        observer.postPresented(post);
    }
}
