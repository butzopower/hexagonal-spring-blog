package com.shitpimps.hexagonalblog.blog.repositories;

import com.shitpimps.hexagonalblog.blog.values.Post;

public interface PostRepository {
    Post save(Post post);
    Post get(String id);
}
