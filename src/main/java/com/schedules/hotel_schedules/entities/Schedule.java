package com.schedules.hotel_schedules.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Schedule")
public class Schedule implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EntranceTime")
    private String entranceTime;

    @Column(name = "ExitTime")
    private String exitTime;

    @Column(name = "Bill")
    private double bill;

    @Column(name = "Fk_Id_Room", nullable = false)
    private int fk_Id_Room;

    @Column(name = "Fk_Id_Client", nullable = false)
    private int fk_Id_Client;

    @Column(name = "Status", nullable = false)
    private RoomStatus roomStatus;

    @Column(name = "fk_Id_Order", nullable = false)
    private int fk_Id_Order;

    public Schedule() {
    }

    public Schedule(Long id, String entranceTime, String exitTime, double bill, int fk_Id_Room,
            int fk_Id_Client) {

        this.id = id;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
        this.bill = bill;
        this.fk_Id_Room = fk_Id_Room;
        this.fk_Id_Client = fk_Id_Client;
        this.roomStatus = RoomStatus.FREE;
        this.fk_Id_Order = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntrance() {
        return entranceTime;
    }

    public void setEntrance(String entranceTime) {
        this.entranceTime = entranceTime;
    }

    public String getExit() {
        return exitTime;
    }

    public void setExit(String exitTime) {
        this.exitTime = exitTime;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public int getFk_Id_Room() {
        return fk_Id_Room;
    }

    public void setFk_Id_Room(int fk_Id_Room) {
        this.fk_Id_Room = fk_Id_Room;
    }

    public int getFk_Id_Client() {
        return fk_Id_Client;
    }

    public void setFk_Id_Client(int fk_Id_Client) {
        this.fk_Id_Client = fk_Id_Client;
    }

    public String getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(String entranceTime) {
        this.entranceTime = entranceTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getfk_Id_Order() {
        return fk_Id_Order;
    }

    public void setfk_Id_Order(int fk_Id_Order) {
        this.fk_Id_Order = fk_Id_Order;
    }

    @Override
    public String toString() {
        return "Schedule [id=" + id + ", entranceTime=" + entranceTime + ", exitTime=" + exitTime + ", bill=" + bill
                + ", fk_Id_Room=" + fk_Id_Room + ", fk_Id_Client=" + fk_Id_Client + ", roomStatus=" + roomStatus
                + ", fk_Id_Order=" + fk_Id_Order + "]";
    }

}
