package com.elbertribeiro.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TAB_SERVIDOR", schema = "DEPLOY")
public class Servidor {
    @Id
    @Column(name = "SERVIDOR_ID", columnDefinition = "NUMBER")
    private Long id;

    @Column(name = "SERVIDOR_ENDERECO")
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "AMBIENTE_ID", referencedColumnName = "AMBIENTE_ID")
    private Ambiente ambiente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
}
