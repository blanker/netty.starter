package com.dongbawen.netty.starter.the7th;

import com.dongbawen.netty.starter.the6th.MyProtoBuf;
import com.dongbawen.netty.starter.the6th.MyProtoBufServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;


/**
 * Created by blank on 2017/6/25.
 */
public class MyProtoBufMultiMsgServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(ProtoBufInfo.Data.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(new MyProtoBufMultiMsgServerHandler());
    }
}
