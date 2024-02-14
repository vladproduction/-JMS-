package com.vladproduction.dataprocessordbapp.messaging.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.dataprocessordbapp.model.Data;
import jakarta.jms.*;
import org.springframework.stereotype.Component;

@Component
public class DataProducer {

    private ConnectionFactory connectionFactory;
    private Destination destination;
    private ObjectMapper objectMapper;

    public DataProducer(ConnectionFactory connectionFactory, Destination destination, ObjectMapper objectMapper) {
        this.connectionFactory = connectionFactory;
        this.destination = destination;
        this.objectMapper = objectMapper;
    }

    public void send(Data data){
        try (Connection connection = connectionFactory.createConnection()){
            Session session = connection.createSession();
            MessageProducer producer = session.createProducer(destination);
            String content = transform(data);
            TextMessage message = session.createTextMessage();
            message.setText(content);
            producer.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private String transform(Data data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }
}
