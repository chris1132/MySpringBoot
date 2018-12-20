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
        //EventLoop ����൱��һ�������̣߳���Netty��������ʹ���IO������̡߳�
        //EventLoopGroup �������Ϊ�����EventLoop���з�������һ���࣬��EventLoop��һ���顣

        //�������ս���������
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        //���������Ѿ������յ�����
        EventLoopGroup workGroup = new NioEventLoopGroup();

        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try {
            //����һ���Է���������ú���������,����nio����ĸ���������,
            ServerBootstrap bootstrap = new ServerBootstrap();
            /**1���������߳���������ͻ���ͨ����accept�Ͷ�д�¼�*/
            bootstrap.group(mainGroup, workGroup)
                    .channel(NioServerSocketChannel.class)/**2���󶨷����ͨ��NioServerSocketChannel*/
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new NettyServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)//����Socket���ӵĲ���
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            /**�����Ƕ�ServerBootstrap ������*/

            //�󶨶˿ڣ���������
            /**4�������˿�*/
//            bootstrap.bind(port).sync();
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            System.out.println("TCP������������");
            //�ȴ�������socket�ر�
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
