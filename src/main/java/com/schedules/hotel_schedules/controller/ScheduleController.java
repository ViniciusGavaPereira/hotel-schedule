package com.schedules.hotel_schedules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedules.hotel_schedules.dtos.*;
import com.schedules.hotel_schedules.entities.Schedule;
import com.schedules.hotel_schedules.service.ScheduleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(value = "/all")
    public List<Schedule> findAll() {
        List<Schedule> result = scheduleService.findAll();
        return result;
    }

    @PostMapping("/test/create/v1/")
    public void postMethodName(@RequestBody RoomDto roomTest) {
        scheduleService.saveRoom(roomTest);

    }

}
