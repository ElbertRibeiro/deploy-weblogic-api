package com.elbertribeiro.service;

import com.elbertribeiro.applicationevent.ErroEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class ErroSubscriber implements ApplicationListener<ErroEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ErroSubscriber.class);


    @Override
    public void onApplicationEvent(ErroEvent event) {
        logger.error("Escutando evento de erro");
        logger.error("Fila: {}", event.getErro().getFila());
        logger.error("Erro: {}", event.getErro().getMensagemErro());
        logger.error("Trace: {}", event.getErro().getTraceErro());
    }
}
