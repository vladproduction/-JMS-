package com.vladproduction.dataprocessordbapp.messaging.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.dataprocessordbapp.dao.DataDao;
import com.vladproduction.dataprocessordbapp.model.Data;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DataConsumer {

    private ObjectMapper objectMapper;

    private DataDao dataDao;

    public DataConsumer(ObjectMapper objectMapper, DataDao dataDao) {
        this.objectMapper = objectMapper;
        this.dataDao = dataDao;
    }

    @JmsListener(destination = "queue.destination")
    public void onMessage(Message message) throws JMSException {
        System.out.println("receive: " + message);
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            String content = textMessage.getText();
            Data transform = transform(content);
            dataDao.saveData(transform);

        }


    }

    private Data transform(String text){
        try {
            return objectMapper.readValue(text, Data.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
