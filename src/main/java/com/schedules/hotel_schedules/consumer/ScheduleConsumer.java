package com.schedules.hotel_schedules.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConsumer {

    @RabbitListener(queues = "${broker.queue.schedules.name}")
    public void listenEmailQueue(@Payload String string) {
        System.out.println(string);
    }
}
