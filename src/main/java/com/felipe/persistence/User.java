package com.felipe.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String user_name;
    private String user_location;

//    @OneToMany(mappedBy = "postAuthorId", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
//    private List<Integer> user_posts;

    public User(Integer user_id, String user_name, String user_location) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_location = user_location;
    }

    public User(){

    }

    public User(String user_name, String user_location) {
        this.user_name = user_name;
        this.user_location = user_location;
    }

    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_location() {
        return user_location;
    }
    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }
//    public List<Integer> getUser_posts() {
//        return user_posts;
//    }
//
//    public void setUser_posts(List<Integer> user_posts) {
//        this.user_posts = user_posts;
//    }

}
