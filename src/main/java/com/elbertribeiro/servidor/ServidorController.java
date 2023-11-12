package com.elbertribeiro.servidor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("servidor")
public class ServidorController {
    private final ServidorRepository servidorRepository;

    public ServidorController(ServidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
    }

    @GetMapping
    public List<Servidor> getAmbiente() {
        return servidorRepository.findAll();
    }
}
