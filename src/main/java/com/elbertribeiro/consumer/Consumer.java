package com.elbertribeiro.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    //TODO: se o processamento der errado, publicar o evento de erro em uma tabela usando event do java

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private static final String TOPIC = "Tópico: {}";
    private static final String KEY = "Key: {}";
    private static final String HEADERS = "Headers: {}";
    private static final String PARTION = "Partion: {}";
    private static final String ORDER = "Order: {}";

    @Value("${deploy.ambiente.dev}")
    private String topicNameDev;

    @Value("${deploy.ambiente.hom}")
    private String topicNameHom;

    @Value("${deploy.ambiente.prod}")
    private String topicNameProd;

    @KafkaListener(topics = "${deploy.ambiente.dev}", groupId = "${deploy.grupo-id}")
    public void consumeDev(ConsumerRecord<String, String> payload) {
        logger.info(TOPIC, topicNameDev);
        logger.info(KEY, payload.key());
        logger.info(HEADERS, payload.headers());
        logger.info(PARTION, payload.partition());
        logger.info(ORDER, payload.value());
    }

    @KafkaListener(topics = "${deploy.ambiente.hom}", groupId = "${deploy.grupo-id}")
    public void consumeHom(ConsumerRecord<String, String> payload) {
        logger.info(TOPIC, topicNameHom);
        logger.info(KEY, payload.key());
        logger.info(HEADERS, payload.headers());
        logger.info(PARTION, payload.partition());
        logger.info(ORDER, payload.value());
    }

    @KafkaListener(topics = "${deploy.ambiente.prod}", groupId = "${deploy.grupo-id}")
    public void consumeProd(ConsumerRecord<String, String> payload) {
        logger.info(TOPIC, topicNameProd);
        logger.info(KEY, payload.key());
        logger.info(HEADERS, payload.headers());
        logger.info(PARTION, payload.partition());
        logger.info(ORDER, payload.value());
    }
}
