package com.schedules.hotel_schedules.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedules.hotel_schedules.dtos.ClientDto;
import com.schedules.hotel_schedules.dtos.RoomDto;
import com.schedules.hotel_schedules.entities.Schedule;
import com.schedules.hotel_schedules.http.PersonClient;
import com.schedules.hotel_schedules.http.RoomClient;
import com.schedules.hotel_schedules.repositories.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PersonClient personClient;

    @Autowired
    private RoomClient roomClient;

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public ClientDto findPerson(Integer id) {

        ClientDto client = personClient.findById(id);
        return client;

    }

    public RoomDto findRoom(Integer id) {
        RoomDto room = roomClient.findById(id);
        return room;
    }

    public Schedule createSchedule(Schedule scheduleInput) {
        return scheduleRepository.save(scheduleInput);
    }

    /*
     * public void findById(Integer id) {
     * scheduleProducer.scheduleSearch(id);
     * }
     */
}
