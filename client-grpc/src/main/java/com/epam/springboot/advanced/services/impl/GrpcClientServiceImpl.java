package com.epam.springboot.advanced.services.impl;

import com.epam.springboot.advanced.services.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.sample.proto.PingPongServiceGrpc;
import org.springframework.grpc.sample.proto.PingRequest;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class GrpcClientServiceImpl implements GrpcClientService {

    private final PingPongServiceGrpc.PingPongServiceBlockingStub stub;

    @Autowired
    public GrpcClientServiceImpl(PingPongServiceGrpc.PingPongServiceBlockingStub stub) {
        this.stub = stub;
    }


    @Override
    public String sendPing() {
        return stub.sayPong(PingRequest.newBuilder()
                .setName("Ping")
                .build())
                .getMessage();
    }
}
