package com.dongbawen.grpc;

import com.dongbawen.proto.MyRequest;
import com.dongbawen.proto.MyResponse;
import com.dongbawen.proto.MyResponseList;
import com.dongbawen.proto.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class MyGrpcServiceImpl extends  StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        String username = request.getUsername();
        System.out.println("客户端请求参数： " + username);

        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<MyRequest> getSomeListByUsernames(StreamObserver<MyResponseList> responseObserver) {

        StreamObserver<MyRequest> result = new StreamObserver<MyRequest>(){
            private List<MyRequest> requestList = new ArrayList<>();
            private int count = 0;

            @Override
            public void onNext(MyRequest value) {
                System.out.println("收到客户端的第 "+(++count)+" 个参数: " + value.getUsername());
                requestList.add(value);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println(" * 共收到客户端的参数: " + count+ "");
                requestList.forEach( e -> System.out.println(e.getUsername()));
                System.out.println(" * ");

                MyResponseList.Builder resultBuilder = MyResponseList.newBuilder();

                //requestList.stream().map( e-> MyResponse.newBuilder().setRealname("真-"+e.getUsername()).build())
                //        .reduce(MyResponseList.newBuilder(),  MyResponseList.Builder::addList, (l, r) -> l.addList(r.build().) );
                requestList.forEach( e -> {
                    ;
                    resultBuilder.addList(MyResponse.newBuilder().setRealname("真-"+e.getUsername()).build());
                });

                responseObserver.onNext(resultBuilder.build());

                responseObserver.onCompleted();
            }
        };

        return result;

    }

    @Override
    public void getSomeStream(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println(" * 收到客户端请求参数是： " + request.getUsername())        ;
        System.out.println("   准备连续不断返回客户端一些信息： ");

        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("李四").build());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("王五").build());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("找刘").build());

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<MyRequest> getSomeStreamByStream(StreamObserver<MyResponse> responseObserver) {
        StreamObserver<MyRequest> result = new StreamObserver<MyRequest>() {
            private int count = 0;
            @Override
            public void onNext(MyRequest value) {
                count ++;
                System.out.println(" 接收到客户端的第 " + count+ " 个参数： " + value.getUsername() );
                responseObserver.onNext(MyResponse.newBuilder().setRealname("真-"+value.getUsername()).build());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println(" * 服务器端结束。");
                responseObserver.onCompleted();
            }
        };

        return result;
    }
}
