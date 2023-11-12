package com.elbertribeiro.deploy;

public class DeployDto {
    private String nomeAplicacao;
    private String servidor;


    public DeployDto(String nomeAplicacao, String servidor) {
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
