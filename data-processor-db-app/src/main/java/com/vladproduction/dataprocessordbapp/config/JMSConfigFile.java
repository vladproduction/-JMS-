package com.vladproduction.dataprocessordbapp.config;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JMSConfigFile {

    @Value("${destination.name}")
    private String destinationName;

    @Bean
    public ConnectionFactory connectionFactory(){
        return new ActiveMQConnectionFactory();
    }

    @Bean
    public Destination destination(){
        return new ActiveMQQueue(destinationName);
    }
}
