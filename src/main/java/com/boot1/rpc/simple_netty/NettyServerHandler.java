package com.boot1.rpc.simple_netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;

/**
 * Created by wangchaohui on 2018/3/12.
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    private String responseMsg = "hello client, got your message \n ----from server";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object message) throws Exception {
        //读数据从ByteBuf到一个byte[]数组
        //--start--
        ByteBuf result = (ByteBuf) message;
        byte[] res = new byte[result.readableBytes()];
        result.readBytes(res);
        String resStr = new String(res);
        //--end--
        System.out.println("NettyServerHandler--------------------------" + resStr);
        //释放资源
        result.release();

        //数据转换成ByteBuf
        ByteBuf responEncode = ctx.alloc().buffer(4 * responseMsg.length());
        responEncode.writeBytes(responseMsg.getBytes());
        ctx.write(responEncode);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

}
