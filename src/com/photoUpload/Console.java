package com.photoUpload;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
        private static final Scanner scanner = new Scanner(System.in);
        public static void show() {}
        public static int getNumPhotos() {

            int numPhotos = 0;
            while (true) {
                try {
                    System.out.print("Choose multiple photos to upload: ");
                    numPhotos = scanner.nextInt();
                    scanner.nextLine();

                    if (numPhotos > 10) {
                        throw new IllegalArgumentException("Error: you can only upload up to 10 photos.\n");
                    }
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.\n");
                    scanner.nextLine(); // consume the invalid input
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            return numPhotos;
        }


        public static void uploadPhotos(User currentUser, PhotoProcessor processor, int numPhotos) {
            for (int i = 0; i < numPhotos; i++) {
                System.out.print("Enter the file name: ");
                String fileName = scanner.nextLine();

                Photo photo = new Photo(fileName, currentUser);
                setPhotoCaption(photo);

                processor.process(photo);
                System.out.println();
            }

            String userEmail = getUserEmail();
            currentUser.setEmail(userEmail);
        }

        public static void setPhotoCaption(Photo photo) {
            System.out.print("Write a caption:");
            String caption = scanner.nextLine();
            System.out.println();
            photo.setCaption(caption.isEmpty() ? null : caption);
        }

        public static String getUserEmail() {
            System.out.print("Enter your email address: ");
            String userEmail = scanner.nextLine();
            return userEmail;
        }

        public static void initialPrompt() {
            System.out.println("PhotoShareX\n");
            System.out.println("To upload photos, please follow the instructions below.");
            System.out.println("You can upload up to 10 photos per session.\n");
        }
    }

