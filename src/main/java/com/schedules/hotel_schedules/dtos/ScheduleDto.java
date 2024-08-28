package com.schedules.hotel_schedules.dtos;

import java.time.LocalDate;

import com.schedules.hotel_schedules.entities.Schedule;

public class ScheduleDto {

    private Long id;
    private LocalDate entranceTime;
    private LocalDate exitTime;
    private double bill;
    private int fk_Id_Room;
    private int fk_Id_Client;
    private int fk_Id_Order;

    public ScheduleDto() {
    }

    public ScheduleDto(Long id, LocalDate entranceTime, LocalDate exitTime, double bill, int fk_Id_Room,
            int fk_Id_Client,
            int fk_Id_Order) {
        this.id = id;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
        this.bill = bill;
        this.fk_Id_Room = fk_Id_Room;
        this.fk_Id_Client = fk_Id_Client;
        this.fk_Id_Order = fk_Id_Order;
    }

    public ScheduleDto(Schedule schedule) {
        id = schedule.getId();
        entranceTime = schedule.getEntranceTime();
        exitTime = schedule.getExitTime();
        bill = schedule.getBill();
        fk_Id_Room = schedule.getFk_Id_Room();
        fk_Id_Client = schedule.getFk_Id_Client();
        fk_Id_Order = schedule.getFk_Id_Order();
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

    public int getFk_Id_Order() {
        return fk_Id_Order;
    }

    public void setFk_Id_Order(int fk_Id_Order) {
        this.fk_Id_Order = fk_Id_Order;
    }

    @Override
    public String toString() {
        return "ScheduleDto [id=" + id + ", entranceTime=" + entranceTime + ", exitTime=" + exitTime + ", bill=" + bill
                + ", fk_Id_Room=" + fk_Id_Room + ", fk_Id_Client=" + fk_Id_Client + ", fk_Id_Order=" + fk_Id_Order
                + "]";
    }

}
