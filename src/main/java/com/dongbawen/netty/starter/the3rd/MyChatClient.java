package com.dongbawen.netty.starter.the3rd;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyChatClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).
                    handler(new LoggingHandler(LogLevel.TRACE)).
                    handler(new MyChatClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).channel();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for(;;) {
                String line = br.readLine();
                channel.writeAndFlush(line + "\r\n");
            }
            //channelFuture.sync();
            //channelFuture.channel().closeFuture().sync();

        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

}
