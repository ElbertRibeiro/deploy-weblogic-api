package com.elbertribeiro.applicationevent;

import com.elbertribeiro.dto.DeployDto;
import org.springframework.context.ApplicationEvent;

public class DeployEvent extends ApplicationEvent {
    private final DeployDto deploy;
    public DeployEvent(Object source, DeployDto deploy) {
        super(source);
        this.deploy = deploy;
    }

    public DeployDto getAplicacao() {
        return deploy;
    }
}
