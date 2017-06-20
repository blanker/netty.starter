package com.dongbawen.netty.starter.the4th;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * Created by blank on 2017/6/19.
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            switch (event.state()) {
                case ALL_IDLE:
                    System.out.println("All_Idle");
                    break;
                case READER_IDLE:
                    System.out.println("Reader_Idle");
                    break;
                case WRITER_IDLE:
                    System.out.println("Writer_Idle");
                    break;
            }

            ctx.channel().close();
        }
    }
}
