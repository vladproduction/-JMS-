package com.vladproduction.dataprocessordbapp.controller;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQQueueBrowser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("api/queue_browser")
public class QueueBrowserController {

    private ConnectionFactory connectionFactory;
    private Destination destination;

    public QueueBrowserController(ConnectionFactory connectionFactory, Destination destination) {
        this.connectionFactory = connectionFactory;
        this.destination = destination;
    }

    @GetMapping()
    public List<String> getQueueInfo() throws JMSException {
        List<String> list = new ArrayList<>();
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession();
        QueueBrowser queueBrowser = session.createBrowser((Queue) destination);
        Enumeration enumeration = queueBrowser.getEnumeration();
        while (enumeration.hasMoreElements()){

            TextMessage textMessage = (TextMessage) enumeration.nextElement();
            list.add(textMessage.getText());
        }
        connection.stop();
        return list;
    }
}
