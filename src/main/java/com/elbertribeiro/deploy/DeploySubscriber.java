package com.elbertribeiro.deploy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class DeploySubscriber implements ApplicationListener<DeployEvent> {
    private static final Logger logger = LoggerFactory.getLogger(DeploySubscriber.class);

    @Override
    public void onApplicationEvent(DeployEvent event) {
        logger.info("Escutando evento de deploy da aplicacao {}", event.getAplicacao().getNomeAplicacao());
    }
}
