package com.schedules.hotel_schedules.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.schedules.hotel_schedules.dtos.ClientDto;
import com.schedules.hotel_schedules.dtos.RoomDto;
import com.schedules.hotel_schedules.dtos.ScheduleTimeDto;
import com.schedules.hotel_schedules.entities.Schedule;
import com.schedules.hotel_schedules.http.InventoryClient;
import com.schedules.hotel_schedules.http.PersonClient;
import com.schedules.hotel_schedules.http.RoomClient;
import com.schedules.hotel_schedules.repositories.ScheduleRepository;

import exception.CustomApplicationException;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PersonClient personClient;

    @Autowired
    private RoomClient roomClient;

    @Autowired
    private InventoryClient inventoryClient;

    public ClientDto findPerson(Integer id) {

        ClientDto client = personClient.findById(id);
        return client;

    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public RoomDto findRoom(Integer id) {
        RoomDto room = roomClient.findById(id);
        return room;
    }

    public RoomDto updateRoomStatus(Schedule scheduleInput) {
        RoomDto room = roomClient.updateRoomStatus(
                scheduleInput.getFk_Id_Room(),
                scheduleInput.getRoomStatus());
        return room;
    }

    public Schedule findById(Long id) {
        Schedule result = scheduleRepository.findById(id)
                .orElseThrow(() -> new CustomApplicationException("Schedule with ID: " + id + " not found",
                        HttpStatus.NOT_FOUND));
        return result;
    }

    // Vai mexer bastante aqui
    public Schedule createSchedule(Schedule scheduleInput) {

        // Connect to Client's endpoint and verify if the client exist's
        findPerson(scheduleInput.getFk_Id_Client());

        // Connect to Room's endpoint and verify if the room exist's
        findRoom(scheduleInput.getFk_Id_Room());

        scheduleInput.verifyDates(scheduleInput.getEntranceTime(), scheduleInput.getExitTime());

        scheduleInput.setFk_Id_Order(inventoryClient.findLastOrder());
        return scheduleRepository.save(scheduleInput);

    }

    public void deleteScheduleById(Long id) {
        scheduleRepository.deleteById(id);

    }

    public Schedule updateSchedule(Schedule scheduleInput) {
        Schedule schedule = scheduleRepository.findById(scheduleInput.getId())
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        // Connect to Client's endpoint
        findPerson(scheduleInput.getFk_Id_Client());

        // Connect to Room's endpoint
        RoomDto room = findRoom(scheduleInput.getFk_Id_Room());
        System.out.println(room.getRoomStatus());

        scheduleInput.verifyDates(scheduleInput.getEntranceTime(), scheduleInput.getExitTime());

        schedule.setEntranceTime(scheduleInput.getEntranceTime());
        schedule.setExitTime(scheduleInput.getExitTime());
        schedule.setBill(scheduleInput.getBill());
        schedule.setFk_Id_Room(scheduleInput.getFk_Id_Room());
        schedule.setFk_Id_Client(scheduleInput.getFk_Id_Client());
        schedule.setRoomStatus(scheduleInput.getRoomStatus());
        schedule.setFk_Id_Order(scheduleInput.getFk_Id_Order());
        scheduleRepository.save(schedule);

        return schedule;
    }

    public int createOrderNumber() {
        return inventoryClient.findLastOrder();
    }

    public List<Schedule> findByTime(ScheduleTimeDto schedule) {
        return scheduleRepository.findByTime(schedule.getEntranceDay(), schedule.getExitDay());
    }

}
