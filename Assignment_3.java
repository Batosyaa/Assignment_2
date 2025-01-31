package com.Java_Practice;

import java.util.Scanner;

public class Assignment_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database roomDAO = new Database();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Check Room Availability");
            System.out.println("3. Book a Room");
            System.out.println("4. Clear a Room");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Rooms:");
                    roomDAO.getAvailableRooms().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Enter the Room Number: ");
                    int roomCheck = scanner.nextInt();
                    if (roomDAO.isRoomAvailable(roomCheck)) {
                        System.out.println("Room is available.");
                    } else {
                        System.out.println("Room is booked or does not exist.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number to book: ");
                    int bookRoom = scanner.nextInt();
                    if (roomDAO.bookRoom(bookRoom)) {
                        System.out.println("Room booked successfully.");
                    } else {
                        System.out.println("Room not available or does not exist.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Room Number to clear: ");
                    int clearRoom = scanner.nextInt();
                    if (roomDAO.clearRoom(clearRoom)) {
                        System.out.println("Room cleared successfully.");
                    } else {
                        System.out.println("Room not booked or does not exist.");
                    }
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
