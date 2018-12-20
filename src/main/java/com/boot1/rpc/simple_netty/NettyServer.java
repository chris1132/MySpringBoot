package com.boot1.rpc.simple_netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by wangchaohui on 2018/3/12.
 */
public class NettyServer {

    private int port = 9999;
    private String host = "127.0.0.1";

    public NettyServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() {
        //EventLoop 这个相当于一个处理线程，是Netty接收请求和处理IO请求的线程。
        //EventLoopGroup 可以理解为将多个EventLoop进行分组管理的一个类，是EventLoop的一个组。

        //用来接收进来的连接
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        //用来处理已经被接收的连接
        EventLoopGroup workGroup = new NioEventLoopGroup();

        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try {
            //这是一个对服务端做配置和启动的类,启动nio服务的辅助启动类,
            ServerBootstrap bootstrap = new ServerBootstrap();
            /**1、绑定两个线程组来处理客户端通道的accept和读写事件*/
            bootstrap.group(mainGroup, workGroup)
                    .channel(NioServerSocketChannel.class)/**2、绑定服务端通道NioServerSocketChannel*/
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new NettyServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)//设置Socket连接的参数
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            /**上述是对ServerBootstrap 的配置*/

            //绑定端口，接收连接
            /**4、监听端口*/
//            bootstrap.bind(port).sync();
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            System.out.println("TCP服务器已启动");
            //等待服务器socket关闭
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
            mainGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new NettyServer("127.0.0.1", 9998).run();
    }
}
