package com.epam.springboot.advanced.controllers;

import com.epam.springboot.advanced.services.GrpcClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GrpcClientController {

    private final GrpcClientService grpcClientService;

    public GrpcClientController(GrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    @GetMapping("/ping")
    public Mono<String> ping() {
        return Mono.fromCallable(grpcClientService::sendPing);
    }
}