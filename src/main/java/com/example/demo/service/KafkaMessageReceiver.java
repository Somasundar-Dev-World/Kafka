package com.example.demo.service;

import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class KafkaMessageReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageReceiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.name}")
    public void receive(User user) {

        LOGGER.info("received user='{}'", user.toString());

        latch.countDown();
    }
}
