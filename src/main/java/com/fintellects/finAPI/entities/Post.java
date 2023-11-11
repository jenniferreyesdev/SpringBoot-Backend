package com.fintellects.finAPI.entities;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String email;
    String message;
    String imageURL;

    boolean isActive = true;

    public Post(){}

    public Post(Integer id, String email, String post) {
        this.id = id;
        this.email = email;
        this.message = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return message;
    }

    public void setPost(String post) {
        this.message = post;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    //might need to cut out
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}


