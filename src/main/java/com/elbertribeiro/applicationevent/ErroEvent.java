package com.elbertribeiro.applicationevent;

import com.elbertribeiro.model.dto.ErroDto;
import org.springframework.context.ApplicationEvent;

import java.io.Serial;
import java.io.Serializable;


public class ErroEvent extends ApplicationEvent implements Serializable {
    @Serial
    private static final long serialVersionUID = 766469612450853108L;
    private final ErroDto erro;

    public ErroEvent(Object source, ErroDto erro) {
        super(source);
        this.erro = erro;
    }

    public ErroDto getErro() {
        return erro;
    }
}
