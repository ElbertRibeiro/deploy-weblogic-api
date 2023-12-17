package com.elbertribeiro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public record ProducerController(KafkaTemplate<String, String> kafkaTemplate,
                                 @Value("${topic.name.producer}")
                                 String topicName) {
    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @GetMapping
    public String send() {
        var message = "gestao-rh";
        logger.info("Payload enviado: {}", message);
        kafkaTemplate.send(topicName, message);
        return message;
    }

    @GetMapping("erro")
    public String sendErro() {
        var message = "gestao-rh1";
        logger.info("Payload enviado: {}", message);
        kafkaTemplate.send(topicName, message);
        return message;
    }
}
