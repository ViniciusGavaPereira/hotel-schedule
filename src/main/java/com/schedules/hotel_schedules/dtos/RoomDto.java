package com.schedules.hotel_schedules.dtos;

import com.schedules.hotel_schedules.entities.RoomStatus;

public class RoomDto {

    private Integer roomNumber;
    private String name;
    private Float pricePerHour;
    private RoomStatus roomStatus;

    public RoomDto() {
    }

    public RoomDto(Integer roomNumber, String name, Float pricePerHour, RoomStatus roomStatus) {
        this.roomNumber = roomNumber;
        this.name = name;
        this.pricePerHour = pricePerHour;
        this.roomStatus = roomStatus;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return "RoomDto [roomNumber=" + roomNumber + ", name=" + name + ", pricePerHour=" + pricePerHour
                + ", roomStatus=" + roomStatus + "]";
    }

}
