package com.elbertribeiro.dto;

public record ErroDto(
        String fila,
        String mensagemErro,
        String traceErro
) {
}
