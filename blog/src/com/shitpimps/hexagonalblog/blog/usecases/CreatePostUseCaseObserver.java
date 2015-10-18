package com.shitpimps.hexagonalblog.blog.usecases;

import com.shitpimps.hexagonalblog.blog.values.Post;

public interface CreatePostUseCaseObserver {
    void postCreated(Post post);
}