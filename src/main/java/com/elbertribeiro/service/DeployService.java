package com.elbertribeiro.service;

import com.elbertribeiro.applicationevent.DeployEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class DeployService implements ApplicationListener<DeployEvent> {
    private static final Logger logger = LoggerFactory.getLogger(DeployService.class);

    @Override
    public void onApplicationEvent(DeployEvent event) {
        logger.info("Escutando evento de deploy");
        logger.info("aplicacao: {}", event.getAplicacao().getNomeAplicacao());
        logger.info("servidor: {}", event.getAplicacao().getServidor());
    }
}
