package com.photoUpload;

public class User {
    private String email;

    public User() {
        this.email = "";
    }
    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
