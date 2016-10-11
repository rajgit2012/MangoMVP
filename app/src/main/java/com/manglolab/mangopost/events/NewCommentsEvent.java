package com.manglolab.mangopost.events;

import com.manglolab.mangopost.model.pojo.Comment;

import java.util.List;

public class NewCommentsEvent {
    List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public NewCommentsEvent(List<Comment> comments) {
        this.comments = comments;
    }
}
