package com.elbertribeiro.repository;

import com.elbertribeiro.model.entity.Aplicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long> {
    Aplicacao findAplicacaoByNomeAplicacao(String nomeAplicacao);
}
