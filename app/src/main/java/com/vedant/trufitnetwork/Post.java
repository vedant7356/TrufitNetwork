package com.vedant.trufitnetwork;

public class Post {
    String caption,comment_count,full_name,like_count;

    @Override
    public String toString() {
        return "Post{" +
                "caption='" + caption + '\'' +
                ", comment_count='" + comment_count + '\'' +
                ", full_name='" + full_name + '\'' +
                ", like_count='" + like_count + '\'' +
                '}';
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getLike_count() {
        return like_count;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public Post(String caption, String comment_count, String full_name, String like_count) {
        this.caption = caption;
        this.comment_count = comment_count;
        this.full_name = full_name;
        this.like_count = like_count;
    }

    public Post() {
    }
}
