package com.schedules.hotel_schedules.service;

import java.util.List;
import java.util.stream.Collectors;

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

        // Verify if the date of the entrance os before the exit date
        scheduleInput.verifyDates(scheduleInput.getEntranceTime(), scheduleInput.getExitTime());

        if ((verifyAvailability(new ScheduleTimeDto(scheduleInput), scheduleInput.getFk_Id_Room())) == true) {

            scheduleInput.setFk_Id_Order(inventoryClient.findLastOrder());
            return scheduleRepository.save(scheduleInput);
        } else {
            throw new CustomApplicationException("Room is already schedule to this period  of time",
                    HttpStatus.FORBIDDEN);
        }

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

        if ((verifyAvailability(new ScheduleTimeDto(scheduleInput), scheduleInput.getFk_Id_Room())) == true) {
            schedule.setEntranceTime(scheduleInput.getEntranceTime());
            schedule.setExitTime(scheduleInput.getExitTime());
            schedule.setBill(scheduleInput.getBill());
            schedule.setFk_Id_Room(scheduleInput.getFk_Id_Room());
            schedule.setFk_Id_Client(scheduleInput.getFk_Id_Client());
            schedule.setRoomStatus(scheduleInput.getRoomStatus());
            schedule.setFk_Id_Order(scheduleInput.getFk_Id_Order());
            scheduleRepository.save(schedule);

            return schedule;
        } else {
            throw new CustomApplicationException("Room is already schedule to this period of time",
                    HttpStatus.FORBIDDEN);
        }

    }

    public int createOrderNumber() {
        return inventoryClient.findLastOrder();
    }

    public List<Schedule> findByTime(ScheduleTimeDto scheduleInput) {

        List<Schedule> result = scheduleRepository.findByTime(scheduleInput.getEntranceDay(),
                scheduleInput.getExitDay());

        scheduleInput.verifyDates(scheduleInput.getEntranceDay(), scheduleInput.getExitDay());

        if (!result.isEmpty()) {
            return result;
        } else {
            throw new CustomApplicationException("There is no schedule in this period of time",
                    HttpStatus.NOT_FOUND);
        }

    }

    public Boolean verifyAvailability(ScheduleTimeDto scheduleInput, int idRoomInput) {

        List<Schedule> schedulesSearch = scheduleRepository.findByTime(scheduleInput.getEntranceDay(),
                scheduleInput.getExitDay());

        Schedule result = schedulesSearch.stream()
                .filter(schedule -> schedule.getFk_Id_Room() == idRoomInput)
                .findFirst()
                .orElse(null);

        if (result != null) {
            System.out.println(result.toString());

            return false;
        } else {
            System.out.println("Room is free to schedule");
            return true;
        }

    }

    public List<RoomDto> findAllRooms(ScheduleTimeDto scheduleInput) {

        // Pega todos as schedules de um determinado periodo
        List<Schedule> schedules = findByTime(scheduleInput);

        // Puxa apenas os id's destas schedules
        List<Integer> listIds = schedules.stream()
                .map(e -> Math.toIntExact(e.getFk_Id_Room()))
                .collect(Collectors.toList());

        // Busca todas as rooms do sistema
        List<RoomDto> result = roomClient.findByAll();

        for (int x = 0; x < result.size(); x++) {
            Integer y = result.get(x).verifyRoom(listIds);
            if (y == -1) {

                result.remove(result.get(x));
            }
        }
        return result;
    }

}
