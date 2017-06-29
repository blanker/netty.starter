package com.dongbawen.proto;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by blank on 2017/6/29.
 */
public class StudentServer  {
    private static final Logger logger = Logger.getLogger(StudentServer.class.getName());

    private final int port;
    private final Server server;

    public StudentServer(int port) throws IOException {
        this(ServerBuilder.forPort(port), port);
    }
    public StudentServer(ServerBuilder<?> serverBuilder, int port) {
        this.port = port;
        server = serverBuilder.addService(new StudentService())
                .build();
    }

    /** Start serving requests. */
    public void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may has been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                StudentServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    /** Stop serving requests and shutdown resources. */
    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main method.  This comment makes the linter happy.
     */
    public static void main(String[] args) throws Exception {
        StudentServer server = new StudentServer(8980);
        server.start();
        server.blockUntilShutdown();
    }

    private static class StudentService extends StudentServiceGrpc.StudentServiceImplBase {
        @Override
        public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
            String username = request.getUsername();
            System.out.println("Got request param: " + username);

            MyResponse myResponse = MyResponse.newBuilder().setRealname("zhangsan").build();
            responseObserver.onNext(myResponse);

            responseObserver.onCompleted();
        }
    }
}
