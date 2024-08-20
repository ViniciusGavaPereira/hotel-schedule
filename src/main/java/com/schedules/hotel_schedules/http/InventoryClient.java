package com.schedules.hotel_schedules.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schedules.hotel_schedules.dtos.OrdersDto;

@FeignClient("hotel-inventory-ms")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/orders/findLastOrder/{id}")
    OrdersDto findLastOrder(@PathVariable int id);

}
