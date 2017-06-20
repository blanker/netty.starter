package com.dongbawen.netty.starter.the1st;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Created by blank on 2017/6/18.
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        System.out.println(Thread.currentThread().getName() + "( "+ this + "): init" );

        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("httpServerCodec", new HttpServerCodec())
                .addLast("testHttpServerHandler", new TestHttpServerHandler());
    }
}
