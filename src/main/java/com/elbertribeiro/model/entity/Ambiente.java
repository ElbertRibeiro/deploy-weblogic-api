package com.elbertribeiro.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TAB_AMBIENTE", schema = "DEPLOY")
public class Ambiente {
    @Id
    @Column(name = "AMBIENTE_ID", columnDefinition = "NUMBER")
    private Long id;

    @Column(name = "AMBIENTE")
    private String ambienteDescricao;

    @Column(name = "AMBIENTE_RESUMIDO")
    private String ambienteResumido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmbienteDescricao() {
        return ambienteDescricao;
    }

    public void setAmbienteDescricao(String ambienteDescricao) {
        this.ambienteDescricao = ambienteDescricao;
    }

    public String getAmbienteResumido() {
        return ambienteResumido;
    }

    public void setAmbienteResumido(String ambienteResumido) {
        this.ambienteResumido = ambienteResumido;
    }
}
