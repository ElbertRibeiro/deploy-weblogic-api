package com.elbertribeiro.deploy;

import org.springframework.context.ApplicationEvent;

public class DeployEvent extends ApplicationEvent {
    private final Deploy deploy;
    public DeployEvent(Object source, Deploy deploy) {
        super(source);
        this.deploy = deploy;
    }

    public Deploy getAplicacao() {
        return deploy;
    }
}
