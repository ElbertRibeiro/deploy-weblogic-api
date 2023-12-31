package com.elbertribeiro.model.entity;

import com.elbertribeiro.applicationevent.DeployEvent;
import com.elbertribeiro.applicationevent.ErroEvent;
import com.elbertribeiro.model.dto.DeployDto;
import com.elbertribeiro.model.dto.ErroDto;
import com.elbertribeiro.service.AplicacaoService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    private final AplicacaoService aplicacaoService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public Consumer(AplicacaoService aplicacaoService, ApplicationEventPublisher applicationEventPublisher) {
        this.aplicacaoService = aplicacaoService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @KafkaListener(topics = "${deploy.ambiente.dev}", groupId = "${deploy.grupo-id}")
    public void consumeDev(ConsumerRecord<String, String> payload) {
        try {
            this.loggerConsumer(payload);
            var aplicacao = aplicacaoService.buscaAplicacao(payload.value());
            logger.info("Endereço de Deploy: {}", aplicacao.getServidorDesenvolvimento().getEndereco());
            var deploy = new DeployDto(aplicacao.getNomeAplicacao(), aplicacao.getServidorDesenvolvimento().getEndereco());
            applicationEventPublisher.publishEvent(new DeployEvent(this, deploy));
        } catch (Exception e) {
            applicationEventPublisher.publishEvent(new ErroEvent(this, new ErroDto(payload.topic(), e.getMessage(), e.fillInStackTrace().toString())));
        }
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
