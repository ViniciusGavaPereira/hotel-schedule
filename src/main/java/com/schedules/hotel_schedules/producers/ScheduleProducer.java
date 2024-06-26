package com.schedules.hotel_schedules.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.schedules.hotel_schedules.dtos.RoomDto;

@Component
public class ScheduleProducer {

    // Instacia de um template rabbit que injeta o rabbit template no projeto
    final RabbitTemplate rabbitTemplate;

    // Construtor de rabbit template
    public ScheduleProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Recupera o nome da fila que vamos enviar a requisição
    @Value(value = "${broker.queue.room.name}")
    private String routingKey;

    public void saveRoom(RoomDto test) {
        rabbitTemplate.convertAndSend("", routingKey, test.toString());
    }

}
