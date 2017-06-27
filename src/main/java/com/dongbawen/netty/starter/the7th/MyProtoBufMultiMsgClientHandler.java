package com.dongbawen.netty.starter.the7th;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * Created by blank on 2017/6/25.
 */
public class MyProtoBufMultiMsgClientHandler extends SimpleChannelInboundHandler<ProtoBufInfo.Data> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ProtoBufInfo.Data msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ProtoBufInfo.Data msg = null;
        ProtoBufInfo.Data.Builder builder = ProtoBufInfo.Data.newBuilder();
        int i = new Random().nextInt(3);
        switch ( i) {
            case 0:
                msg = builder.setDataType(ProtoBufInfo.Data.DataType.PersonType)
                        .setUser(ProtoBufInfo.User.newBuilder().setAge(10).setEmail("wangzhiyun@sina.com").setName("张三").build()).build();
                break;
            case 1:
                msg = builder.setDataType(ProtoBufInfo.Data.DataType.DogType)
                        .setDog(ProtoBufInfo.Dog.newBuilder().setName("旺财").setAddress("华府").build()).build();
                break;
            case 2:
                msg = builder.setDataType(ProtoBufInfo.Data.DataType.CatType)
                        .setCat(ProtoBufInfo.Cat.newBuilder().setAge(20).setName("miaomiao").build()).build();
                break;
        }
        ctx.writeAndFlush(msg);
    }
}
