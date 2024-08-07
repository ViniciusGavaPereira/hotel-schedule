package com.schedules.hotel_schedules.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schedules.hotel_schedules.dtos.ClientDto;

@FeignClient("hotel-client-ms")
public interface PersonClient {

    @RequestMapping(method = RequestMethod.GET, value = "/client/id/{id}")
    ClientDto findById(@PathVariable Integer id);

}
