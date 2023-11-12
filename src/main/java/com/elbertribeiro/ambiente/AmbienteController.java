package com.elbertribeiro.ambiente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ambiente")
public class AmbienteController {
    private final AmbienteRepository ambienteRepository;

    public AmbienteController(AmbienteRepository ambienteRepository) {
        this.ambienteRepository = ambienteRepository;
    }

    @GetMapping
    public List<Ambiente> getAmbiente(){
        return ambienteRepository.findAll();
    }
}
