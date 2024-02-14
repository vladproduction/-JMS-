package com.vladproduction.dataprocessordbapp.controller;

import com.vladproduction.dataprocessordbapp.messaging.producer.DataProducer;
import com.vladproduction.dataprocessordbapp.model.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {

    private DataProducer dataProducer;

    public ProducerController(DataProducer dataProducer) {
        this.dataProducer = dataProducer;
    }

    @PostMapping
    public void createData(@RequestBody Data data){
        dataProducer.send(data);
    }
}
