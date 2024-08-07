package com.schedules.hotel_schedules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableJpaRepositories
@SpringBootApplication
public class HotelSchedulesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelSchedulesApplication.class, args);
	}

}
