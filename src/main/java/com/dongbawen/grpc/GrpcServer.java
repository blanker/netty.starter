package com.dongbawen.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    private int port = 8899;
    private Server server = null;

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new MyGrpcServiceImpl())
                .build()
                .start();
        System.out.println("server started and listening on port: " + port);
        Runtime.getRuntime().addShutdownHook(new Thread( ()->{
            System.out.println(" * \n shutdown server");
            GrpcServer.this.stop();
        }));
    }

    private void stop() {
        if (null != server) {
            System.out.println(" * \n Stop the server. ");
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (null != server ) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        final GrpcServer grpcServer = new GrpcServer();
        grpcServer.start();
        grpcServer.blockUntilShutdown();
    }
}
