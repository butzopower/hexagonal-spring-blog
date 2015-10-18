package com.shitpimps.hexagonalblog.blog.values;

public class Post {
    private String id;
    private String title;
    private String content;

    public Post(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }
}