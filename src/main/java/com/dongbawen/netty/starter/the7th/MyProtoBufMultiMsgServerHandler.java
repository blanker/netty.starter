package com.dongbawen.netty.starter.the7th;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * Created by blank on 2017/6/25.
 */
public class MyProtoBufMultiMsgServerHandler extends SimpleChannelInboundHandler<ProtoBufInfo.Data> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ProtoBufInfo.Data msg ) throws Exception {
        switch (msg.getDataType()){
            case PersonType:
                ProtoBufInfo.User user = msg.getUser();
                System.out.println(user.getAge());
                System.out.println(user.getEmail());
                System.out.println(user.getName());
                break;
            case DogType:
                System.out.println(msg.getDog().getAddress());
                System.out.println(msg.getDog().getName());
                break;
            case CatType:
                System.out.println(msg.getCat().getAge());
                System.out.println(msg.getCat().getName());
                break;
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //cause.printStackTrace();
        ctx.close();
    }
}
