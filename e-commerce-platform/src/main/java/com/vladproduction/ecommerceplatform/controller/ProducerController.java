package com.vladproduction.ecommerceplatform.controller;

import com.vladproduction.ecommerceplatform.components.producer.OrderProducer;
import com.vladproduction.ecommerceplatform.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/e-commerce")
public class ProducerController {

    @Autowired
    OrderProducer orderProducer;

    @PostMapping("/sendMsg")
    public void sendMsg(@RequestBody Order order){
        orderProducer.sendOrderToDestination(order);
    }

}
