package com.example.cgnprojectmongo.service.producer;

import com.example.cgnprojectmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

//    private final KafkaTemplate<String, String> stringKafkaTemplate;
//    private final KafkaTemplate<String, User> customKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, String> stringKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, User> customKafkaTemplate;

//    public KafkaProducerService(KafkaTemplate<String, String> stringKafkaTemplate,
//                                KafkaTemplate<String, User> customKafkaTemplate) {
//        this.stringKafkaTemplate = stringKafkaTemplate;
//        this.customKafkaTemplate = customKafkaTemplate;
//    }

    public void sendStringMessage(String topic, String message) {
        stringKafkaTemplate.send(topic, message);
    }

    public void sendCustomMessage(String topic, User message) {
        customKafkaTemplate.send(topic, message);
    }
}
