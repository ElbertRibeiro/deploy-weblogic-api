package com.elbertribeiro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TAB_APLICACAO", schema = "DEPLOY")
@Getter
@Setter
public class Aplicacao {
    @Id
    @Column(name = "APLICACAO_ID", columnDefinition = "NUMBER")
    private Long id;

    @Column(name = "APLICACAO_DESCRICAO")
    private String nomeAplicacao;

    @Column(name = "APLICACAO_SERVIDOR_DEV")
    private Long servidorDesenvolvimento;

    @Column(name = "APLICACAO_SERVIDOR_HOM")
    private Long servidorHomologacao;

    @Column(name = "APLICACAO_SERVIDOR_PROD")
    private Long servidorProducao;

}
