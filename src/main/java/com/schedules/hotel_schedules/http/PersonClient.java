package com.schedules.hotel_schedules.http;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schedules.hotel_schedules.dtos.ClientDto;

@FeignClient("hotel-client-ms")
public interface PersonClient {

    @RequestMapping(method = RequestMethod.GET, value = "/client//cpf/{cpf}")
    ClientDto findByCPF(@PathVariable String cpf);

}
