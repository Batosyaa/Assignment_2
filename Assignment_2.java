package com.Java_Practice;

import java.util.*;

class Room {
    private final int RoomNumber;
    private final String type;
    private final double price;
    private boolean IsBooked;

    public Room(int RoomNumber, String type, double price, boolean IsBooked) {
        this.RoomNumber = RoomNumber;
        this.type = type;
        this.price = price;
        this.IsBooked = IsBooked;
    }

    public int GetRoom() {
        return RoomNumber;
    }

    public String GetType() {
        return type;
    }

    public double GetPrice() {
        return price;
    }

    public boolean GetIsBooked() {
        return IsBooked;
    }

    public void SetIsBooked(boolean Booked) {
        IsBooked = Booked;
    }

    @Override
    public String toString() {
        return "Room [Number = " + RoomNumber + ", Type = " + type + ", Price = " + price + ", Availability: " + IsBooked + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room room = (Room) obj;
        return RoomNumber == room.RoomNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(RoomNumber);
    }
}

class Guest {
    private final String Name;
    private final int Age;

    public Guest(String Name, int Age) {
        this.Name = Name;
        this.Age = Age;
    }

    public String GetName() {
        return Name;
    }

    public int GetAge() {
        return Age;
    }

    @Override
    public String toString() {
        return "Guest [Name = " + Name + ", Age = " + Age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Guest guest = (Guest) obj;
        return Age == guest.Age && Objects.equals(Name, guest.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Age);
    }
}

class Booking {
    private final Guest guest;
    private final Room room;

    public Booking(Guest guest, Room room) {
        this.guest = guest;
        this.room = room;
        room.SetIsBooked(true);
    }

    public Guest getGuest() {return guest;}
    public Room getRoom() {return room;}

    @Override
    public String toString() {
        return "Booking [Guest = " + guest + ", Room = " + room + "]";
    }
}

public class Assignment_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Room> rooms = Arrays.asList(
                new Room(101, "Single", 500.65, false),
                new Room(102, "Single", 510, false),
                new Room(103, "Single", 520, false),
                new Room(201, "Double", 800, false),
                new Room(202, "Double", 810, false),
                new Room(203, "Double", 820, false),
                new Room(301, "King size", 1010, false),
                new Room(302, "King size", 1100, false),
                new Room(303, "King size", 1500, false)
        );

        Guest guest1 = new Guest("Alina", 25);
        Guest guest2 = new Guest("Peter", 32);



        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Available Rooms");
            System.out.println("2. Check room availability");
            System.out.println("3. Book the room");
            System.out.println("4. Clear the room");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); // Moved inside the loop

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Rooms:");
                    rooms.stream()
                            .filter(Room -> !Room.GetIsBooked())
                            .sorted(Comparator.comparing(Room::GetPrice))
                            .forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Enter the Room number: ");
                    int roomCheck = scanner.nextInt();
                    Room room = rooms.stream().filter(Room -> Room.GetRoom() == roomCheck).findFirst().orElse(null);
                    if (room != null) {
                        System.out.println(room.GetIsBooked() ? "Room is booked." : "Room is available.");
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter Room number to book: ");
                    int bookRoom = scanner.nextInt();
                    Room roomToBook = rooms.stream().filter(r -> r.GetRoom() == bookRoom && !r.GetIsBooked()).findFirst().orElse(null);
                    if (roomToBook != null) {
                        System.out.println("Enter Guest Name: ");
                        String name = scanner.next();
                        System.out.println("Enter Guest Age: ");
                        int age = scanner.nextInt();
                        Guest guest = new Guest(name, age);
                        Booking booking = new Booking(guest, roomToBook);
                        System.out.println("Room booked successfully: " + booking);
                    } else {
                        System.out.println("Room not available or does not exist.");
                    }
                    break;
                case 4:
                    System.out.println("Enter Room number to clear: ");
                    int clearRoom = scanner.nextInt();
                    Room roomToClear = rooms.stream().filter(r -> r.GetRoom() == clearRoom).findFirst().orElse(null);
                    if (roomToClear != null && roomToClear.GetIsBooked()) {
                        roomToClear.SetIsBooked(false);
                        System.out.println("Room cleared successfully.");
                    } else {
                        System.out.println("Room not booked or does not exist.");
                    }
                    break;
                case 5:
                    exit = true; // Exits the loop
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
