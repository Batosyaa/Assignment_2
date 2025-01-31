package com.Java_Practice;

public class Room {
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
        return "Room [Number = " + RoomNumber + ", Type = " + type + ", Price = " + price + ", IsBooked = " + IsBooked + "]";
    }
}
