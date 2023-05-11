package com.photoUpload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePhotoSaver {
    private Connection connection;

    public DatabasePhotoSaver (Connection connection) {
        this.connection = connection;
    }

    public void savePhoto(Photo photo) {

        try {
            PreparedStatement psmt = connection.prepareStatement
                    ("INSERT INTO photos (filename, caption, user_email) VALUES (?, ?, ?)");
            psmt.setString(1, photo.getFileName());
            psmt.setString(2, photo.getCaption());
            psmt.setString(3, photo.getUserEmail());
            int numOfRowsAffected = psmt.executeUpdate();

            if (numOfRowsAffected == 1) {
                System.out.println("Photo saved to database");
            } else {
                System.out.println("Error: Failed to save photo to database.");
            }
            psmt.close();

        } catch (SQLException e) {
            System.err.println("Error: Failed to save photo to database" + e.getMessage());
        }
    }
}
