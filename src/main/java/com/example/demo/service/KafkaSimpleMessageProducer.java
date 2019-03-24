package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSimpleMessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageReceiver.class);

    @Autowired
    private KafkaTemplate simpletemplate;

    @Value("${kafka.topic.name.simpletopic}")
    private String topicName;


    public boolean publishMessage(String message) {

        LOGGER.info("Publishing the user message to topic : "+message);

        simpletemplate.send(topicName, message);

        LOGGER.info("Published the message successfully.");

        return true;
    }

}
