package com.schedules.hotel_schedules.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("hotel-inventory-ms")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/orders/findLastOrder")
    int findLastOrder();

}
