package com.schedules.hotel_schedules.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedules.hotel_schedules.entities.Schedule;
import com.schedules.hotel_schedules.service.ScheduleService;

@FeignClient(name = "schedule-service", url = "")
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    @GetMapping(value = "/all")
    public List<Schedule> findAll() {

        List<Schedule> result = scheduleService.findAll();
        return result;
    }

}
