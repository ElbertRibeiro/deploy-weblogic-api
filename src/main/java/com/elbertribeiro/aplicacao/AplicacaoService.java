package com.elbertribeiro.aplicacao;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record AplicacaoService(AplicacaoRepository repository) {

    public Aplicacao buscaAplicacao(String nomeAplicacao) {
        return Optional.ofNullable(repository.findAplicacaoByNomeAplicacao(nomeAplicacao))
                .orElseThrow(() -> new RuntimeException("Aplicacao não encontrada"));
    }
}