package com.vladproduction.ecommerceplatform.components.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.ecommerceplatform.model.Order;
import jakarta.jms.*;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

    private final ConnectionFactory connectionFactory;
    private final Destination destination;
    private final ObjectMapper objectMapper;

    public OrderProducer(ConnectionFactory connectionFactory, Destination destination, ObjectMapper objectMapper) {
        this.connectionFactory = connectionFactory;
        this.destination = destination;
        this.objectMapper = objectMapper;
    }

    public void sendOrderToDestination(Order order){
        try (Connection connection = connectionFactory.createConnection()){

            Session session = connection.createSession();
            MessageProducer messageProducer = session.createProducer(destination);

            String orderAsString = transformOrderAsString(order);

            TextMessage sessionTextMessage = session.createTextMessage();

            sessionTextMessage.setText(orderAsString);

            messageProducer.send(sessionTextMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private String transformOrderAsString(Order order) throws JsonProcessingException {
        return objectMapper.writeValueAsString(order);
    }
}
