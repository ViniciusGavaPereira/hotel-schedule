package com.schedules.hotel_schedules.dtos;

public class ScheduleTimeDto {

    private String entranceDay;
    private String entranceTime;
    private String exitDay;
    private String exitTime;

    public ScheduleTimeDto() {
    }

    public ScheduleTimeDto(String entranceDay, String entranceTime, String exitDay, String exitTime) {
        this.entranceDay = entranceDay;
        this.entranceTime = entranceTime;
        this.exitDay = exitDay;
        this.exitTime = exitTime;
    }

    public String getEntranceDay() {
        return entranceDay;
    }

    public void setEntranceDay(String entranceDay) {
        this.entranceDay = entranceDay;
    }

    public String getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(String entranceTime) {
        this.entranceTime = entranceTime;
    }

    public String getExitDay() {
        return exitDay;
    }

    public void setExitDay(String exitDay) {
        this.exitDay = exitDay;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

}
