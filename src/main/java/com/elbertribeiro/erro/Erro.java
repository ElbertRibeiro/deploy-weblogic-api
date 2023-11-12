package com.elbertribeiro.erro;

public class Erro {
    private String fila;
    private String mensagemErro;
    private String traceErro;

    public Erro(String fila, String mensagemErro, String traceErro) {
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
