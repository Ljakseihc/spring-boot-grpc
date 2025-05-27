package com.epam.springboot.advanced.services;

import io.grpc.stub.StreamObserver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.grpc.sample.proto.PingPongServiceGrpc;
import org.springframework.grpc.sample.proto.PingRequest;
import org.springframework.grpc.sample.proto.PongReply;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
class GrpcServerService extends PingPongServiceGrpc.PingPongServiceImplBase {

    private final AtomicInteger increment = new AtomicInteger(0);

    private static final Log log = LogFactory.getLog(GrpcServerService.class);

    @Override
    public void sayPong(PingRequest req, StreamObserver<PongReply> responseObserver) {
        log.info("Hello " + increment.get());
        PongReply reply = PongReply.newBuilder().setMessage("Pong " + increment.incrementAndGet()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
