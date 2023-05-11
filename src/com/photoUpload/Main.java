package com.photoUpload;

import java.sql.Connection;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Console.initialPrompt();
        Scanner scanner = new Scanner(System.in);
        Console console = new Console();

        Connection connection = Database.createDBConnection();
        var processor = new PhotoProcessor(
                new DatabasePhotoSaver(connection),
                new EmailService()
        );

        int numPhotos = Console.getNumPhotos();
        String userEmail = console.getUserEmail();
        User currentUser = new User(userEmail);

        Console.uploadPhotos(currentUser, processor, numPhotos);
    }
}