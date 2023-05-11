package com.photoUpload;

import java.util.UUID;

public class Photo {
    private UUID id;
    private String fileName;
    private User user;
    private String caption;



    public Photo(String fileName, User user, String caption) {
        this.id = UUID.randomUUID();
        this.fileName = fileName;
        this.user = user;
        this.caption = caption;
    }

    public Photo(String fileName, User user) {
        this(fileName, user, null);
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUserEmail() {
        return user.getEmail();
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption)  {
        this.caption = caption;
    }

}
