package com.elbertribeiro.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class ProducerController {
    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${topic.name.producer}")
    private String topicName;

    public ProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    public String send() {
        var message = "teste";
        logger.info("Payload enviado: {}", message);
        kafkaTemplate.send(topicName, message);
        return message;
    }
}