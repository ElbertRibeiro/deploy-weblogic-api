package com.elbertribeiro.ambiente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TAB_AMBIENTE", schema = "DEPLOY")
@Getter
@Setter
public class Ambiente {
    @Id
    @Column(name = "AMBIENTE_ID", columnDefinition = "NUMBER")
    private Long id;

    @Column(name = "AMBIENTE")
    private String ambienteDescricao;

    @Column(name = "AMBIENTE_RESUMIDO")
    private String ambienteResumido;
}
