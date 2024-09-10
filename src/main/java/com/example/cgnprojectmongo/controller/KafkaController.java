package com.example.cgnprojectmongo.controller;


import com.example.cgnprojectmongo.service.KafkaConsumerService;
import com.example.cgnprojectmongo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        System.out.println("send message:"+ message);
        kafkaProducerService.sendMessage("cgn-topic-01", message);
        return ResponseEntity.ok("Message sent successfully");
    }

}
