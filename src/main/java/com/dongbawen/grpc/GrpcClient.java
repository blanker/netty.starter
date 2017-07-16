package com.dongbawen.grpc;

import com.dongbawen.proto.MyRequest;
import com.dongbawen.proto.MyResponse;
import com.dongbawen.proto.MyResponseList;
import com.dongbawen.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class GrpcClient {
    private static String serverName = "localhost";
    private static int port = 8899;

    public static void main(String[] args) throws InterruptedException {
        GrpcClient grpcClient = new GrpcClient();
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(serverName, 8899).usePlaintext(true).build();
        StudentServiceGrpc.StudentServiceStub studentServiceStub = StudentServiceGrpc.newStub(managedChannel);

        StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        MyResponse response = studentServiceBlockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("blank").build());
        System.out.println("服务器调用后返回结果： " + response.getRealname());

        System.out.println("**********************************");

        StreamObserver<MyResponseList> streamObserver = new StreamObserver<MyResponseList>() {
            @Override
            public void onNext(MyResponseList value) {
                System.out.println(" * on next :");
                value.getListList().forEach( (e) -> System.out.println(e.getRealname()) );
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println(" * on completed.");
            }
        };
        StreamObserver<MyRequest> requestStreamObserver = studentServiceStub.getSomeListByUsernames(streamObserver);

        requestStreamObserver.onNext(MyRequest.newBuilder().setUsername("张三").build());
        requestStreamObserver.onNext(MyRequest.newBuilder().setUsername("李四").build());
        requestStreamObserver.onNext(MyRequest.newBuilder().setUsername("王五").build());
        requestStreamObserver.onNext(MyRequest.newBuilder().setUsername("找刘").build());
        requestStreamObserver.onCompleted();

        studentServiceStub.getSomeStream(MyRequest.newBuilder().setUsername("blank").build(), new StreamObserver<MyResponse>() {
            private int count = 0;
            @Override
            public void onNext(MyResponse value) {
                System.out.println(" * 接收到服务器端返回的第 "+ (++count )+" 个结果: " + value.getRealname());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println(" * 接收服务器端返回的结果完成了。");
            }
        });

        StreamObserver<MyRequest> someStreamByStreamRequest = studentServiceStub.getSomeStreamByStream(new StreamObserver<MyResponse>() {
            private int count = 0;

            @Override
            public void onNext(MyResponse value) {
                System.out.println(" * 接收到服务器端返回的第 " + (++count) + " 个结果: " + value.getRealname());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println(" * 接收服务器端返回的结果完成了。");
            }
        });

        someStreamByStreamRequest.onNext(MyRequest.newBuilder().setUsername("张三").build());
        Thread.sleep(500);
        someStreamByStreamRequest.onNext(MyRequest.newBuilder().setUsername("李四").build());
        Thread.sleep(500);
        someStreamByStreamRequest.onNext(MyRequest.newBuilder().setUsername("王五").build());
        Thread.sleep(500);
        someStreamByStreamRequest.onNext(MyRequest.newBuilder().setUsername("找刘").build());
        Thread.sleep(500);
        someStreamByStreamRequest.onNext(MyRequest.newBuilder().setUsername("天气").build());
        someStreamByStreamRequest.onCompleted();
        //managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        Thread.sleep(5*1000);
        managedChannel.shutdown();
    }
}
