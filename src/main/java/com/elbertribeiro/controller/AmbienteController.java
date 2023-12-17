package com.elbertribeiro.controller;

import com.elbertribeiro.model.entity.Ambiente;
import com.elbertribeiro.repository.AmbienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ambiente")
public record AmbienteController(AmbienteRepository ambienteRepository) {

    @GetMapping
    public List<Ambiente> getAmbiente() {
        return ambienteRepository.findAll();
    }
}
