package com.boot1.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.CharsetUtil;

/**
 * Created by wangchaohui on 2018/3/12.
 */
public class NettyClient {

    public void connect(String host,int port)throws Exception{
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)throws Exception{
                            ch.pipeline()
//                                    .addLast("decoder",new StringDecoder(CharsetUtil.UTF_8))
//                                    .addLast("encoder",new StringDecoder(CharsetUtil.UTF_8))
                                    .addLast(new NettyClientHandler());

                        }
                    });
            ChannelFuture f = b.connect(host,port).sync();
            f.channel().closeFuture().sync();
        }finally{
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        NettyClient client=new NettyClient();
        client.connect("127.0.0.1", 9998);
    }
}
