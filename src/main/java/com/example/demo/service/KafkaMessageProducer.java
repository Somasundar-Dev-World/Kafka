package com.example.demo.service;

import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageReceiver.class);

    @Autowired
    private KafkaTemplate<String, User> kafkatemplae;

    @Value("${kafka.topic.name}")
    private String topicName;


    public boolean publishMessage(User user) {

        LOGGER.info("Publishing the user message to topic : "+user);

        kafkatemplae.send(topicName, user);

        LOGGER.info("Published the message successfully.");

        return true;
    }

}
