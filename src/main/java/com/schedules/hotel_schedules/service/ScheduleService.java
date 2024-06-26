package com.schedules.hotel_schedules.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedules.hotel_schedules.dtos.RoomDto;
import com.schedules.hotel_schedules.entities.Schedule;
import com.schedules.hotel_schedules.producers.ScheduleProducer;
import com.schedules.hotel_schedules.repositories.ScheduleRepository;

import jakarta.transaction.Transactional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleProducer scheduleProducer;

    @Transactional
    public void saveRoom(RoomDto test) {
        scheduleProducer.saveRoom(test);
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

}
