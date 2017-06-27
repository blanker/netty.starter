package com.dongbawen.netty.starter.the6th;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by blank on 2017/6/25.
 */
public class MyProtoBufClientHandler extends SimpleChannelInboundHandler<MyProtoBuf.User> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyProtoBuf.User msg) throws Exception {
        System.out.println("来自服务器端的用户：");
        System.out.println(msg.getAge());
        System.out.println(msg.getEmail());
        System.out.println(msg.getName());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyProtoBuf.User user = MyProtoBuf.User.newBuilder().setAge(10).setEmail("wangzhiyun@sina.com").setName("blank").build();
        ctx.writeAndFlush(user);
    }
}
