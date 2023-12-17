package com.elbertribeiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import static com.elbertribeiro.enums.MyFeatures.DESCRIPTION_UPDATE;

@RestController
public record MyController(FeatureManager featureManager) {

    @GetMapping("/api/some-endpoint")
    public boolean someEndpoint() {
        return featureManager.isActive(DESCRIPTION_UPDATE);
    }
}
