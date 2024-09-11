package com.example.cgnprojectmongo.controller;


import com.example.cgnprojectmongo.domain.User;
import com.example.cgnprojectmongo.service.UserService;
import com.example.cgnprojectmongo.service.producer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private UserService userService;

    @PostMapping("/sendString")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        System.out.println("send message:"+ message);
        kafkaProducerService.sendStringMessage("string-topic", message);
        return ResponseEntity.ok("Str Message sent successfully");
    }

    @PostMapping("/sendUser")
    public ResponseEntity<String> sendUser(@RequestBody User user) {
        System.out.println("send message:"+ user);
        kafkaProducerService.sendCustomMessage("user-topic", user);
        return ResponseEntity.ok("User Message sent successfully");
    }

    @GetMapping("/findUser")
    public ResponseEntity<User> findUser(@RequestParam Integer id) {
        System.out.println("findUser id:"+id);
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


}
