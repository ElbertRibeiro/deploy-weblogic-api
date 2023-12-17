package com.elbertribeiro.controller;

import com.elbertribeiro.model.entity.Aplicacao;
import com.elbertribeiro.repository.AplicacaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("aplicacao")
public record AplicacaoController(AplicacaoRepository aplicacaoRepository) {


    @GetMapping
    public List<Aplicacao> getAmbiente() {
        return aplicacaoRepository.findAll();
    }
}
