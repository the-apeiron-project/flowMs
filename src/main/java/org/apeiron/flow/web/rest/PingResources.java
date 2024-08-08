package org.apeiron.flow.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class PingResources {

    private final Environment env;
    private final String jwtKey;

    public PingResources(Environment env, @Value("${jhipster.security.authentication.jwt.base64-secret}") String jwtKey) {
        this.env = env;
        this.jwtKey = jwtKey;
    }

    @GetMapping("/ping")
    public Mono<HashMap<String, String>> getMethodName() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Port", env.getProperty("local.server.port"));
        map.put("JwtKey", jwtKey);
        map.put("CurrentTime", Instant.now().toString());
        return Mono.just(map);
    }

}
