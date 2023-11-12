package com.elbertribeiro.deploy;

public class Deploy {
    private String nomeAplicacao;
    private String servidor;


    public Deploy(String nomeAplicacao, String servidor) {
        this.nomeAplicacao = nomeAplicacao;
        this.servidor = servidor;
    }

    public String getNomeAplicacao() {
        return nomeAplicacao;
    }

    public String getServidor() {
        return servidor;
    }
}
