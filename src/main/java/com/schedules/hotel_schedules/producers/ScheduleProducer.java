package com.schedules.hotel_schedules.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(test);

            rabbitTemplate.convertAndSend("", routingKey, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
