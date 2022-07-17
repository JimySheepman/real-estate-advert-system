package com.example.advertservice.producer;

import com.example.advertservice.dto.AdvertSendProducerDTO;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertProducer {

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String excahngeName;

    private final RabbitTemplate rabbitTemplate;

    private final Gson gson = new Gson();

    public void sendToQueue(AdvertSendProducerDTO advertSendProducerDTO) {
        String message = gson.toJson(advertSendProducerDTO);
        System.out.println("Notificatin Sent: " + message);
        rabbitTemplate.convertAndSend(excahngeName, routingName, message);
    }
}
