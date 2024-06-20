package com.schedules.hotel_schedules.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Schedule2")
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

    @Override
    public String toString() {
        return "Schedule [id=" + id + ", entrance=" + entranceTime + ", exit=" + exitTime + ", bill=" + bill
                + ", fk_Id_Room="
                + fk_Id_Room + ", fk_Id_Client=" + fk_Id_Client + "]";
    }

}
