package com.elbertribeiro.dto;

import java.io.Serial;
import java.io.Serializable;

public class ErroDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3617411304322427135L;
    private String fila;
    private String mensagemErro;
    private String traceErro;

    public ErroDto(String fila, String mensagemErro, String traceErro) {
        this.fila = fila;
        this.mensagemErro = mensagemErro;
        this.traceErro = traceErro;
    }

    public String getFila() {
        return fila;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public String getTraceErro() {
        return traceErro;
    }
}
