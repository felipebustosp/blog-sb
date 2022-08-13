package com.felipe.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String postTitle;
    private String postContent;
    private String postDate;

//    @ManyToOne (fetch = FetchType.LAZY)
//    private Integer postAuthorId;
//
    public Post() {
    }

    public Post(Integer userId, Integer postAuthorId, String postTitle, String postContent, String postDate) {
        this.postTitle = postTitle;
//      this.postAuthorId = postAuthorId;
        this.postContent = postContent;
        this.postDate = postDate;
    }

    public Integer getPostId() {
        return postId;
    }
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
    public String getPostContent() {
        return postContent;
    }
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
    public String getPostDate() {
        return postDate;
    }
    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

//    public Integer getPostAuthorId() {
//        return postAuthorId;
//    }
//
//    public void setPostAuthor(Integer postAuthorId) {
//        this.postAuthorId = postAuthorId;
//    }
//

}
