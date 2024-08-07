package com.schedules.hotel_schedules.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedules.hotel_schedules.dtos.ClientDto;
import com.schedules.hotel_schedules.entities.Schedule;
import com.schedules.hotel_schedules.http.PersonClient;
import com.schedules.hotel_schedules.repositories.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PersonClient personClient;

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public ClientDto findPerson(String cpf) {

        ClientDto client = personClient.findByCPF(cpf);
        return client;

    }

    /*
     * public void findById(Integer id) {
     * scheduleProducer.scheduleSearch(id);
     * }
     */
}
