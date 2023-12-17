package com.elbertribeiro.model.dto;

public record ErroDto(
        String fila,
        String mensagemErro,
        String traceErro
) {
}
