package com.schedules.hotel_schedules.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.schedules.hotel_schedules.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM schedule WHERE DATE(entrance_time) >=?1 and TIME(entrance_time) >=?2 and DATE(entrance_time) <= ?3  and TIME(entrance_time) <= ?4;")
    List<Schedule> findByTime(String entraceDay, String entranceTime, String exitDay, String exitTime);
}
