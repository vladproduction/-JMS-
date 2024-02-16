package com.vladproduction.dataprocessordbapp;

import com.vladproduction.dataprocessordbapp.controller.ProducerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DataProcessorDbAppApplicationTests {

    @Autowired
    private ProducerController producerController;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    void contextLoads() {
        //todo
        //testRestTemplate.postForEntity("/api/producer", )
    }

}
