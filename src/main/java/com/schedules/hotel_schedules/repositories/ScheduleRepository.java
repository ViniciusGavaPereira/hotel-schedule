package com.schedules.hotel_schedules.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schedules.hotel_schedules.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
