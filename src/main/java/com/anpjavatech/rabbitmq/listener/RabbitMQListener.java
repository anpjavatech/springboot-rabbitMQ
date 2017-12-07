package com.anpjavatech.rabbitmq.listener;

import com.anpjavatech.rabbitmq.entity.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitMQListener implements MessageListener {
    ObjectReader objectReader;

    @Autowired
    public RabbitMQListener(ObjectMapper objectMapper) {
        objectReader = objectMapper.readerFor(Event.class);
    }

    @Override
    public void onMessage(Message message) {
        String receivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
        System.out.println("ReceivedRoutingKey :: "+receivedRoutingKey);
        try {
            Event recievedMessage = objectReader.readValue(message.getBody());
            System.out.println("Name from RecievedMessage is  :: "+recievedMessage.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
