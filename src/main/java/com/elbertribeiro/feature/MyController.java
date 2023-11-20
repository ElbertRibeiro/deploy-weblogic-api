package com.elbertribeiro.feature;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import static com.elbertribeiro.feature.MyFeatures.DESCRIPTION_UPDATE;

@RestController
public class MyController {

    private final FeatureManager featureManager;

    public MyController(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    @GetMapping("/api/some-endpoint")
    public boolean someEndpoint() {
        return featureManager.isActive(DESCRIPTION_UPDATE);
    }
}
