package com.schedules.hotel_schedules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.schedules.hotel_schedules.dtos.ClientDto;
import com.schedules.hotel_schedules.dtos.RoomDto;
import com.schedules.hotel_schedules.dtos.ScheduleDto;
import com.schedules.hotel_schedules.entities.Schedule;
import com.schedules.hotel_schedules.service.ScheduleService;

import exception.CustomApplicationException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<ScheduleDto> findById(@PathVariable Long id) {
        Schedule result = scheduleService.findById(id);

        return new ResponseEntity<ScheduleDto>(new ScheduleDto(result), HttpStatus.OK);
    }

    @GetMapping(value = "/v0.5/test/{idPerson}/{idRoom}")
    public String test(@PathVariable Integer idPerson, @PathVariable Integer idRoom) {

        // Connect to Client's endpoint
        ClientDto clientResult = scheduleService.findPerson(idPerson);

        // Connect to Room's endpoint
        RoomDto roomResult = scheduleService.findRoom(idRoom);
        return "Person: " + clientResult.toString() + "\nRoom: " + roomResult.toString();
    }

    @PostMapping("/create/v1/")
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody Schedule scheduleInput) {

        Schedule schedule = scheduleService.createSchedule(scheduleInput);

        return new ResponseEntity<>(new ScheduleDto(schedule),
                HttpStatus.CREATED);
    }

    @PutMapping("/update/")
    public ResponseEntity<ScheduleDto> updateSchedule(@RequestBody Schedule scheduleInput) {

        try {
            Schedule result = scheduleService.updateSchedule(scheduleInput);
            return new ResponseEntity<ScheduleDto>(new ScheduleDto(result), HttpStatus.OK);

        } catch (EmptyResultDataAccessException e) {
            throw new CustomApplicationException("Schedule not found", HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
        scheduleService.deleteScheduleById(id);
        return new ResponseEntity<>("Schedule with id " + id + " was deleted", HttpStatus.ACCEPTED);
    }

}
