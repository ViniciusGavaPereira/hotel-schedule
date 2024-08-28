package com.schedules.hotel_schedules.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import exception.CustomApplicationException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "EntranceTime", nullable = false)
    private LocalDate entranceTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "ExitTime", nullable = false)
    private LocalDate exitTime;

    @Column(name = "Bill")
    private double bill;

    @Column(name = "Fk_Id_Room", nullable = false)
    private int fk_Id_Room;

    @Column(name = "Fk_Id_Client", nullable = false)
    private int fk_Id_Client;

    @Enumerated(EnumType.STRING) // Usar STRING para mapear o ENUM como uma string no banco de dados
    @Column(name = "roomStatus", nullable = false)
    private RoomStatus roomStatus;

    @Column(name = "fk_Id_Order", nullable = false)
    private int fk_Id_Order;

    public Schedule() {
    }

    public Schedule(Long id, LocalDate entranceTime, LocalDate exitTime, double bill, int fk_Id_Room,
            int fk_Id_Client) {

        this.id = id;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
        this.bill = bill;
        this.fk_Id_Room = fk_Id_Room;
        this.fk_Id_Client = fk_Id_Client;
        this.roomStatus = RoomStatus.OCCUPIED;
        this.fk_Id_Order = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(LocalDate entranceTime) {
        this.entranceTime = entranceTime;
    }

    public LocalDate getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDate exitTime) {
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

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getFk_Id_Order() {
        return fk_Id_Order;
    }

    public void setFk_Id_Order(int fk_Id_Order) {
        this.fk_Id_Order = fk_Id_Order;
    }

    @Override
    public String toString() {
        return "Schedule [id=" + id + ", entranceTime=" + entranceTime + ", exitTime=" + exitTime + ", bill=" + bill
                + ", fk_Id_Room=" + fk_Id_Room + ", fk_Id_Client=" + fk_Id_Client + ", roomStatus=" + roomStatus
                + ", fk_Id_Order=" + fk_Id_Order + "]";
    }

    public boolean verifyDates(LocalDate entranceTime, LocalDate exitTime) {

        if (entranceTime.isBefore(exitTime) || entranceTime.isEqual(exitTime)) {
            return true;
        } else {
            throw new CustomApplicationException("Schedule entrance time cannot be before exit time",
                    HttpStatus.FORBIDDEN);
        }

    }

}
