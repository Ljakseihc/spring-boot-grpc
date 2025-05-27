package com.epam.springboot.advanced.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;
import org.springframework.grpc.sample.proto.PingPongServiceGrpc;

@Configuration
public class GrpcConfiguration {

    @Bean
    PingPongServiceGrpc.PingPongServiceBlockingStub stub(GrpcChannelFactory channels) {
        return PingPongServiceGrpc.newBlockingStub(channels.createChannel("0.0.0.0:8080"));
    }
}
