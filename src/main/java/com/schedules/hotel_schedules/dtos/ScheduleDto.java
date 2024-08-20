package com.schedules.hotel_schedules.dtos;

import com.schedules.hotel_schedules.entities.Schedule;

import jakarta.persistence.Column;

public class ScheduleDto {

    private Long id;
    private String entranceTime;
    private String exitTime;
    private double bill;
    private int fk_Id_Room;
    private int fk_Id_Client;
    private int fk_Id_Pedido;

    public ScheduleDto() {
    }

    public ScheduleDto(Long id, String entranceTime, String exitTime, double bill, int fk_Id_Room, int fk_Id_Client,
            int fk_Id_Pedido) {
        this.id = id;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
        this.bill = bill;
        this.fk_Id_Room = fk_Id_Room;
        this.fk_Id_Client = fk_Id_Client;
        this.fk_Id_Pedido = fk_Id_Pedido;
    }

    public ScheduleDto(Schedule schedule) {
        id = schedule.getId();
        entranceTime = schedule.getEntrance();
        exitTime = schedule.getExit();
        bill = schedule.getBill();
        fk_Id_Room = schedule.getFk_Id_Room();
        fk_Id_Client = schedule.getFk_Id_Client();
        fk_Id_Pedido = schedule.getFk_Id_Pedido();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getFk_Id_Pedido() {
        return fk_Id_Pedido;
    }

    public void setFk_Id_Pedido(int fk_Id_Pedido) {
        this.fk_Id_Pedido = fk_Id_Pedido;
    }

    @Override
    public String toString() {
        return "ScheduleDto [id=" + id + ", entranceTime=" + entranceTime + ", exitTime=" + exitTime + ", bill=" + bill
                + ", fk_Id_Room=" + fk_Id_Room + ", fk_Id_Client=" + fk_Id_Client + ", fk_Id_Pedido=" + fk_Id_Pedido
                + "]";
    }

}
