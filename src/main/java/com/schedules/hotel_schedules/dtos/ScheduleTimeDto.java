package com.schedules.hotel_schedules.dtos;

public class ScheduleTimeDto {

    private String entranceDay;
    private String exitDay;

    public ScheduleTimeDto() {
    }

    public ScheduleTimeDto(String entranceDay, String exitDay) {
        this.entranceDay = entranceDay;
        this.exitDay = exitDay;

    }

    public String getEntranceDay() {
        return entranceDay;
    }

    public void setEntranceDay(String entranceDay) {
        this.entranceDay = entranceDay;
    }

    public String getExitDay() {
        return exitDay;
    }

    public void setExitDay(String exitDay) {
        this.exitDay = exitDay;
    }

}
