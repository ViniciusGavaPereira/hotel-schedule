package com.schedules.hotel_schedules.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schedules.hotel_schedules.dtos.RoomDto;

@FeignClient("hotel-room-ms")
public interface RoomClient {

    @RequestMapping(method = RequestMethod.GET, value = "room/id/{id}")
    RoomDto findById(@PathVariable Integer id);

}
