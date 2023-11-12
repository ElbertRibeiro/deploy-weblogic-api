package com.elbertribeiro.aplicacao;

import com.elbertribeiro.servidor.Servidor;
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

    @ManyToOne
    @JoinColumn(referencedColumnName = "SERVIDOR_ID", name = "APLICACAO_SERVIDOR_DEV")
    private Servidor servidorDesenvolvimento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "SERVIDOR_ID", name = "APLICACAO_SERVIDOR_HOM")
    private Servidor servidorHomologacao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "SERVIDOR_ID", name = "APLICACAO_SERVIDOR_PROD")
    private Servidor servidorProducao;

}
