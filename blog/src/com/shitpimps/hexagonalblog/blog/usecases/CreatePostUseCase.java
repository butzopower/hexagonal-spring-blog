package com.shitpimps.hexagonalblog.blog.usecases;

import com.shitpimps.hexagonalblog.blog.repositories.PostRepository;
import com.shitpimps.hexagonalblog.blog.values.Post;

public class CreatePostUseCase {

    private PostRepository postRepository;
    private CreatePostUseCaseObserver observer;
    private Post post;

    public CreatePostUseCase(PostRepository postRepository,
                             CreatePostUseCaseObserver observer,
                             Post post) {

        this.postRepository = postRepository;
        this.observer = observer;
        this.post = post;
    }

    public void execute() {
        Post savedPost = this.postRepository.save(post);
        this.observer.postCreated(savedPost);
    }
}