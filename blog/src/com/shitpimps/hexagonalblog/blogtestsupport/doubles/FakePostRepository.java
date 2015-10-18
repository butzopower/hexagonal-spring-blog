package com.shitpimps.hexagonalblog.blogtestsupport.doubles;

import com.shitpimps.hexagonalblog.blog.repositories.PostRepository;
import com.shitpimps.hexagonalblog.blog.values.Post;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FakePostRepository implements PostRepository {
    private Map<String, Post> entities;

    public FakePostRepository() {
        this.entities = new HashMap<String, Post>();
    }

    @Override
    public Post save(Post postToCreate) {
        String id = UUID.randomUUID().toString();
        Post createdPost = new Post(id, postToCreate.getTitle(), postToCreate.getContent());
        entities.put(id, createdPost);
        return createdPost;
    }

    @Override
    public Post get(String id) {
        return entities.get(id);
    }
}
