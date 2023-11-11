package com.elbertribeiro.controller;

import com.elbertribeiro.model.Aplicacao;
import com.elbertribeiro.repository.AplicacaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("aplicacao")
public class AplicacaoController {
    private final AplicacaoRepository aplicacaoRepository;

    public AplicacaoController(AplicacaoRepository aplicacaoRepository) {
        this.aplicacaoRepository = aplicacaoRepository;
    }

    @GetMapping
    public List<Aplicacao> getAmbiente() {
        return aplicacaoRepository.findAll();
    }
}
