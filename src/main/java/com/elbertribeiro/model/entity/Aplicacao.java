package com.elbertribeiro.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TAB_APLICACAO", schema = "DEPLOY")
public class Aplicacao {
    @Id
    @Column(name = "APLICACAO_ID", columnDefinition = "NUMBER")
    private Long id;

    @Column(name = "APLICACAO_DESCRICAO")
    private String nomeAplicacao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "SERVIDOR_ID", name = "APLICACAO_SERVIDOR_DEV")
    private Servidor servidorDesenvolvimento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "SERVIDOR_ID", name = "APLICACAO_SERVIDOR_HOM")
    private Servidor servidorHomologacao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "SERVIDOR_ID", name = "APLICACAO_SERVIDOR_PROD")
    private Servidor servidorProducao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAplicacao() {
        return nomeAplicacao;
    }

    public void setNomeAplicacao(String nomeAplicacao) {
        this.nomeAplicacao = nomeAplicacao;
    }

    public Servidor getServidorDesenvolvimento() {
        return servidorDesenvolvimento;
    }

    public void setServidorDesenvolvimento(Servidor servidorDesenvolvimento) {
        this.servidorDesenvolvimento = servidorDesenvolvimento;
    }

    public Servidor getServidorHomologacao() {
        return servidorHomologacao;
    }

    public void setServidorHomologacao(Servidor servidorHomologacao) {
        this.servidorHomologacao = servidorHomologacao;
    }

    public Servidor getServidorProducao() {
        return servidorProducao;
    }

    public void setServidorProducao(Servidor servidorProducao) {
        this.servidorProducao = servidorProducao;
    }
}
