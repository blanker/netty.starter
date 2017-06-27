package com.dongbawen.netty.starter.the6th;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by blank on 2017/6/25.
 */
public class MyProtoBufServerHandler extends SimpleChannelInboundHandler<MyProtoBuf.User> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyProtoBuf.User msg) throws Exception {
        System.out.println("来自客户端的用户：");
        System.out.println(msg.getAge());
        System.out.println(msg.getEmail());
        System.out.println(msg.getName());
        ctx.writeAndFlush(msg);
    }
}
