package com.vladproduction.ecommerceplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class ECommercePlatformApplication {

    public static void main(String[] args) {


        SpringApplication.run(ECommercePlatformApplication.class, args);
//        System.out.println(new Date());
//        System.out.println(Instant.now());
    }

}
