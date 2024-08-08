package com.schedules.hotel_schedules.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.schedules.hotel_schedules.dtos.ClientDto;
import com.schedules.hotel_schedules.dtos.RoomDto;
import com.schedules.hotel_schedules.entities.RoomStatus;
import com.schedules.hotel_schedules.entities.Schedule;
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

    public Schedule findById(Long id) {
        Schedule result = scheduleRepository.findById(id)
                .orElseThrow(() -> new CustomApplicationException("Schedule with ID: " + id + " not found",
                        HttpStatus.NOT_FOUND));
        return result;
    }

    public Schedule createSchedule(Schedule scheduleInput) {

        // Connect to Client's endpoint
        findPerson(scheduleInput.getFk_Id_Client());

        // Connect to Room's endpoint
        RoomDto room = findRoom(scheduleInput.getFk_Id_Room());
        System.out.println(room.getRoomStatus());

        if (room.getRoomStatus() == RoomStatus.FREE) {
            return scheduleRepository.save(scheduleInput);
        } else {
            throw new CustomApplicationException(
                    "Room with id " + room.getId() + " and number " + room.getRoomNumber() +
                            " is already " + room.getRoomStatus().toString().toLowerCase(),
                    HttpStatus.FORBIDDEN);
        }

    }

    public void deleteScheduleById(Long id) {
        scheduleRepository.deleteById(id);

    }

    /*
     * public void findById(Integer id) {
     * scheduleProducer.scheduleSearch(id);
     * }
     */
}
