package com.boot1.rpc.netty_zookeeper_spring.client;


import com.boot1.rpc.netty_zookeeper_spring.protocol.RpcDecoder;
import com.boot1.rpc.netty_zookeeper_spring.protocol.RpcEncoder;
import com.boot1.rpc.netty_zookeeper_spring.protocol.RpcRequest;
import com.boot1.rpc.netty_zookeeper_spring.protocol.RpcResponse;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Created by wangchaohui on 2018/3/16.
 */
public class RpcClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline cp = socketChannel.pipeline();
        cp.addLast(new RpcEncoder(RpcRequest.class));
        cp.addLast(new LengthFieldBasedFrameDecoder(65536, 0, 4, 0, 0));
        cp.addLast(new RpcDecoder(RpcResponse.class));
        cp.addLast(new RpcClientHandler());
    }
}
