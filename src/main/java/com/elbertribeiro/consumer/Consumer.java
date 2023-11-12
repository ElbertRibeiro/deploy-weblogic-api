package com.elbertribeiro.consumer;

import com.elbertribeiro.aplicacao.AplicacaoService;
import com.elbertribeiro.deploy.Deploy;
import com.elbertribeiro.deploy.DeployEvent;
import com.elbertribeiro.erro.Erro;
import com.elbertribeiro.erro.ErroEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    //TODO: se o processamento der errado, publicar o evento de erro em uma tabela usando event do java

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
            var deploy = new Deploy(aplicacao.getNomeAplicacao(), aplicacao.getServidorDesenvolvimento().getEndereco());
            applicationEventPublisher.publishEvent(new DeployEvent(this, deploy));
        } catch (Exception e) {
            applicationEventPublisher.publishEvent(new ErroEvent(this, new Erro(payload.topic(), e.getMessage(), e.fillInStackTrace().toString())));
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
