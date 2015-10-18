package com.shitpimps.hexagonalblog.blog.usecases;

import com.shitpimps.hexagonalblog.blog.values.Post;

public interface PresentPostUseCaseObserver {
    void postPresented(Post post);
}
