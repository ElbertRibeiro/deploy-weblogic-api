package com.elbertribeiro.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "nexus-client", url = "${servico.nexus.url}")
public interface NexusClient {
    @GetMapping("{grupId}/{artefactId}/{version}/")
    Object obtemArtefato(@PathVariable String grupId,
                         @PathVariable String artefactId,
                         @PathVariable String version);

}
