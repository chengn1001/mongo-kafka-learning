package com.example.cgnprojectmongo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    /*
    * 定义了消费者方法
    * */
    @KafkaListener(topics = "cgn-topic-01")
    public void listen(String message) {
        System.out.printf("Received message: %s%n", message);
    }

}
