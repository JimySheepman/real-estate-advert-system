package com.example.advertservice.producer;

import com.example.advertservice.dto.AdvertSendProducerDTO;
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

    public void sendToQueue(AdvertSendProducerDTO advertSendProducerDTO){
        System.out.println("Notificatin Sent: "+advertSendProducerDTO.toString());
        rabbitTemplate.convertAndSend(excahngeName,routingName,advertSendProducerDTO);
    }
}
