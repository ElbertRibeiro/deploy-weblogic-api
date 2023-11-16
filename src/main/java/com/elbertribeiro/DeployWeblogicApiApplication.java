package com.elbertribeiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DeployWeblogicApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeployWeblogicApiApplication.class, args);
    }

}
