package com.vladproduction.ecommerceplatform.configs;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JMSConfiguration {

    @Value("${destination.name}")
    private String destination;

    @Bean
    public ConnectionFactory connectionFactory(){
        //connect to Active MQ
        return new ActiveMQConnectionFactory();
    }

    @Bean
    public Destination destination(){
        //crete destination type and name (in this example as 'queue'); could be as 'topic;
        return new ActiveMQQueue(destination);
    }

}
