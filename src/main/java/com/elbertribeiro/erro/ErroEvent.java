package com.elbertribeiro.erro;

import org.springframework.context.ApplicationEvent;

public class ErroEvent extends ApplicationEvent {
    private final Erro erro;

    public ErroEvent(Object source, Erro erro) {
        super(source);
        this.erro = erro;
    }

    public Erro getErro() {
        return erro;
    }
}
