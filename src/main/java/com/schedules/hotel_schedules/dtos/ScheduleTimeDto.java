package com.schedules.hotel_schedules.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.springframework.http.HttpStatus;

import com.schedules.hotel_schedules.entities.Schedule;

import exception.CustomApplicationException;

public class ScheduleTimeDto {

    private String entranceDay;
    private String exitDay;

    public ScheduleTimeDto() {
    }

    public ScheduleTimeDto(String entranceDay, String exitDay) {
        this.entranceDay = entranceDay;
        this.exitDay = exitDay;

    }

    public ScheduleTimeDto(Schedule schedule) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.entranceDay = schedule.getEntranceTime().format(formatter);
        this.exitDay = schedule.getExitTime().format(formatter);
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

    public boolean verifyDates(String entranceTimeInput, String exitTimeInput) {

        DateTimeFormatter f = new DateTimeFormatterBuilder().parseCaseInsensitive()
                .append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();

        LocalDate entranceTime = LocalDate.parse(entranceTimeInput, f);
        LocalDate exitTime = LocalDate.parse(exitTimeInput, f);

        if (entranceTime.isBefore(exitTime) || entranceTime.isEqual(exitTime)) {
            return true;
        } else {
            throw new CustomApplicationException("Schedule entrance time cannot be before exit time",
                    HttpStatus.FORBIDDEN);
        }

    }
}
