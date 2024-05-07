package com.pluralsight;

public class Reservation {
    String roomType;
    double price;
    int numberOfNight;
    boolean isWeekEnd;
    double total;

    public Reservation(String roomType, int numberOfNight, boolean isWeekEnd) {
        this.roomType = roomType;
        this.numberOfNight = numberOfNight;
        this.isWeekEnd = isWeekEnd;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        price = getRoomType().equalsIgnoreCase("king") ? 139.00 : 124.00;
        price = isWeekEnd() == true ? price * 1.1 : price;
        price = price * getNumberOfNight();
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfNight() {
        return numberOfNight;
    }

    public void setNumberOfNight(int numberOfNight) {
        this.numberOfNight = numberOfNight;
    }

    public boolean isWeekEnd() {
        return isWeekEnd;
    }

    public void setWeekEnd(boolean weekEnd) {
        isWeekEnd = weekEnd;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
