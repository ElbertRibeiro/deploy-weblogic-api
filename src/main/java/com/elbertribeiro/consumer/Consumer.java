package com.elbertribeiro.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    //TODO: se o processamento der errado, publicar o evento de erro em uma tabela usando event do java

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${deploy.ambiente.dev}", groupId = "${deploy.grupo-id}")
    public void consumeDev(ConsumerRecord<String, String> payload) {
        this.loggerConsumer(payload);
    }

    @KafkaListener(topics = "${deploy.ambiente.hom}", groupId = "${deploy.grupo-id}")
    public void consumeHom(ConsumerRecord<String, String> payload) {
        this.loggerConsumer(payload);
    }

    @KafkaListener(topics = "${deploy.ambiente.prod}", groupId = "${deploy.grupo-id}")
    public void consumeProd(ConsumerRecord<String, String> payload) {
        this.loggerConsumer(payload);
    }

    private void loggerConsumer(ConsumerRecord<String, String> payload) {
        logger.info("Tópico: {}", payload.topic());
        logger.info("Key: {}", payload.key());
        logger.info("Headers: {}", payload.headers());
        logger.info("Partion: {}", payload.partition());
        logger.info("Order: {}", payload.value());
    }
}
