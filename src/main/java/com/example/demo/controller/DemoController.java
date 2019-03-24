package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.KafkaMessageProducer;
import com.example.demo.service.KafkaSimpleMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo/kafka/producer")
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private KafkaMessageProducer kafkaservice;

    @Autowired
    private KafkaSimpleMessageProducer simpleMessageService;


    @GetMapping(value = "/simpleMessage", produces = "application/text")
    public @ResponseBody String ProduceSimpleMessage(@RequestParam String message) {

        LOGGER.info("Received the Get request for message : "+message);

        simpleMessageService.publishMessage(message);

        return "Success";

    }

    @PostMapping(value = "/userMessage", produces = "application/text", consumes = "application/json")
    public @ResponseBody String ProduceSimpleMessage(@RequestBody User user) {

        LOGGER.info("Received the POST request message : ");

        kafkaservice.publishMessage(user);

        return "Success";

    }


}
