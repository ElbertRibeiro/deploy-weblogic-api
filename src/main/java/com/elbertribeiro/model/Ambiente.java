package com.elbertribeiro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TAB_AMBIENTE", schema = "DEPLOY")
public class Ambiente {
    @Id
    @Column(name = "AMBIENTE_ID", columnDefinition = "NUMBER")
    private Long id;

    @Column(name = "AMBIENTE")
    private String ambiente;

    @Column(name = "AMBIENTE_RESUMIDO")
    private String ambienteResumido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getAmbienteResumido() {
        return ambienteResumido;
    }

    public void setAmbienteResumido(String ambienteResumido) {
        this.ambienteResumido = ambienteResumido;
    }
}
