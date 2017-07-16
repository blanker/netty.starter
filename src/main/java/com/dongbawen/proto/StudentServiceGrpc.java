package com.dongbawen.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: Student.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.dongbawen.proto.StudentService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dongbawen.proto.MyRequest,
      com.dongbawen.proto.MyResponse> METHOD_GET_REAL_NAME_BY_USERNAME =
      io.grpc.MethodDescriptor.<com.dongbawen.proto.MyRequest, com.dongbawen.proto.MyResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.dongbawen.proto.StudentService", "GetRealNameByUsername"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dongbawen.proto.MyRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dongbawen.proto.MyResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dongbawen.proto.MyRequest,
      com.dongbawen.proto.MyResponseList> METHOD_GET_SOME_LIST_BY_USERNAMES =
      io.grpc.MethodDescriptor.<com.dongbawen.proto.MyRequest, com.dongbawen.proto.MyResponseList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.dongbawen.proto.StudentService", "GetSomeListByUsernames"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dongbawen.proto.MyRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dongbawen.proto.MyResponseList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dongbawen.proto.MyRequest,
      com.dongbawen.proto.MyResponse> METHOD_GET_SOME_STREAM =
      io.grpc.MethodDescriptor.<com.dongbawen.proto.MyRequest, com.dongbawen.proto.MyResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.dongbawen.proto.StudentService", "GetSomeStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dongbawen.proto.MyRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dongbawen.proto.MyResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dongbawen.proto.MyRequest,
      com.dongbawen.proto.MyResponse> METHOD_GET_SOME_STREAM_BY_STREAM =
      io.grpc.MethodDescriptor.<com.dongbawen.proto.MyRequest, com.dongbawen.proto.MyResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.dongbawen.proto.StudentService", "GetSomeStreamByStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dongbawen.proto.MyRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dongbawen.proto.MyResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    return new StudentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUsername(com.dongbawen.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_REAL_NAME_BY_USERNAME, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dongbawen.proto.MyRequest> getSomeListByUsernames(
        io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_SOME_LIST_BY_USERNAMES, responseObserver);
    }

    /**
     */
    public void getSomeStream(com.dongbawen.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_SOME_STREAM, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dongbawen.proto.MyRequest> getSomeStreamByStream(
        io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_SOME_STREAM_BY_STREAM, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_REAL_NAME_BY_USERNAME,
            asyncUnaryCall(
              new MethodHandlers<
                com.dongbawen.proto.MyRequest,
                com.dongbawen.proto.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .addMethod(
            METHOD_GET_SOME_LIST_BY_USERNAMES,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.dongbawen.proto.MyRequest,
                com.dongbawen.proto.MyResponseList>(
                  this, METHODID_GET_SOME_LIST_BY_USERNAMES)))
          .addMethod(
            METHOD_GET_SOME_STREAM,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.dongbawen.proto.MyRequest,
                com.dongbawen.proto.MyResponse>(
                  this, METHODID_GET_SOME_STREAM)))
          .addMethod(
            METHOD_GET_SOME_STREAM_BY_STREAM,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.dongbawen.proto.MyRequest,
                com.dongbawen.proto.MyResponse>(
                  this, METHODID_GET_SOME_STREAM_BY_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractStub<StudentServiceStub> {
    private StudentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUsername(com.dongbawen.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_REAL_NAME_BY_USERNAME, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dongbawen.proto.MyRequest> getSomeListByUsernames(
        io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_GET_SOME_LIST_BY_USERNAMES, getCallOptions()), responseObserver);
    }

    /**
     */
    public void getSomeStream(com.dongbawen.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_SOME_STREAM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dongbawen.proto.MyRequest> getSomeStreamByStream(
        io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_SOME_STREAM_BY_STREAM, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dongbawen.proto.MyResponse getRealNameByUsername(com.dongbawen.proto.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_REAL_NAME_BY_USERNAME, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.dongbawen.proto.MyResponse> getSomeStream(
        com.dongbawen.proto.MyRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_SOME_STREAM, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dongbawen.proto.MyResponse> getRealNameByUsername(
        com.dongbawen.proto.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_REAL_NAME_BY_USERNAME, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USERNAME = 0;
  private static final int METHODID_GET_SOME_STREAM = 1;
  private static final int METHODID_GET_SOME_LIST_BY_USERNAMES = 2;
  private static final int METHODID_GET_SOME_STREAM_BY_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((com.dongbawen.proto.MyRequest) request,
              (io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponse>) responseObserver);
          break;
        case METHODID_GET_SOME_STREAM:
          serviceImpl.getSomeStream((com.dongbawen.proto.MyRequest) request,
              (io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SOME_LIST_BY_USERNAMES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getSomeListByUsernames(
              (io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponseList>) responseObserver);
        case METHODID_GET_SOME_STREAM_BY_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getSomeStreamByStream(
              (io.grpc.stub.StreamObserver<com.dongbawen.proto.MyResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class StudentServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dongbawen.proto.StudentProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceDescriptorSupplier())
              .addMethod(METHOD_GET_REAL_NAME_BY_USERNAME)
              .addMethod(METHOD_GET_SOME_LIST_BY_USERNAMES)
              .addMethod(METHOD_GET_SOME_STREAM)
              .addMethod(METHOD_GET_SOME_STREAM_BY_STREAM)
              .build();
        }
      }
    }
    return result;
  }
}
