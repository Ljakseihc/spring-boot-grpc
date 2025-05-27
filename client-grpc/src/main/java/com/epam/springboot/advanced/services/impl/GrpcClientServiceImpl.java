package com.epam.springboot.advanced.services.impl;

import com.epam.springboot.advanced.services.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.sample.proto.PingPongServiceGrpc;
import org.springframework.grpc.sample.proto.PingRequest;
import org.springframework.grpc.sample.proto.PongReply;
import org.springframework.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientServiceImpl implements GrpcClientService {

    private final PingPongServiceGrpc.PingPongServiceBlockingStub stub;

    @Autowired
    public GrpcClientServiceImpl(PingPongServiceGrpc.PingPongServiceBlockingStub stub) {
        this.stub = stub;
    }


    @Override
    public String sendPing(String message) {
        PingRequest request = PingRequest.newBuilder()
                .setName("Ping")
                .build();

        PongReply response = stub.sayPong(request);
        return response.getMessage();
    }
}
