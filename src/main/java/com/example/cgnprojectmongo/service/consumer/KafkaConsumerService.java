package com.example.cgnprojectmongo.service.consumer;

import com.alibaba.fastjson.JSON;
import com.example.cgnprojectmongo.domain.User;
import com.example.cgnprojectmongo.repository.UserRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumerService {

    @Autowired
    private UserRepository userRepository;


    /*
    * 定义了消费者方法
    * */
//    @KafkaListener(topics = "cgn-topic-01",groupId = "cgnGroup",
//            properties = { "spring.json.value.default.type: java.lang.String" })
//    public void listen(String message) {
//        System.out.printf("Received message: %s%n", message);
//    }

    // 处理 User 类型的消息,保存到mongodb
    @KafkaListener(topics = "user-topic", groupId = "cgnGroup",
            properties = { "spring.json.value.default.type: com.example.cgnprojectmongo.domain.User" })
    public void listenUser(String userStr) {
        try{
            User user = JSON.parseObject(userStr, User.class);

            System.out.println("Received User str message: " + userStr);
            System.out.println("Received User message: " + user);
            userRepository.save(user);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 处理 String 类型的消息
    @KafkaListener(topics = "string-topic", groupId = "cgnGroup",
            properties = { "spring.json.value.default.type: java.lang.String" })
    public void listenString(String message) {
        System.out.println("Received String message: " + message);
    }


}
