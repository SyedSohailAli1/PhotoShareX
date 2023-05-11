package com.photoUpload;

public class PhotoProcessor {
    private DatabasePhotoSaver photoSaver;
    private EmailService emailService;

    public PhotoProcessor(DatabasePhotoSaver photoSaver, EmailService emailService) {
        this.photoSaver = photoSaver;
        this.emailService = emailService;
    }
    public void process(Photo photo) {
        System.out.println("Uploading Post...");
        System.out.println("Post Uploaded!");
        System.out.println("Storing metadata in a SQL Database\n");
        photoSaver.savePhoto(photo);
        emailService.notify(photo.getUser());
    }
}

