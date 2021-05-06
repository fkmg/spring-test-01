package com.sxt.netty.client;

import com.sxt.netty.handler.NettyClientHandler;
import com.sxt.netty.server.NettyServer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;

/**\
 *
 * netty 客户端
 */
public class NettyClient {

    private static final Logger LOGGER = Logger.getLogger(NettyClient.class);

    public static void main( String[] args ) throws InterruptedException {
        //1、创建工作线程
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        //2、创建客户端启动程序
        Bootstrap bootstrap = new Bootstrap();

        try {
            //3、配置客户端配置
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        /**
                         * 对workerGroup的SocketChannel设置处理器
                         * @param socketChannel
                         * @throws Exception
                         */
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //加入处理器
                            socketChannel.pipeline().addLast(new NettyClientHandler());
                        }
                    });

            LOGGER.info("netty client start。。");

            //启动服务器(并绑定端口)，bind是异步操作，sync方法是等待异步操作执行完毕
            ChannelFuture cf = bootstrap.connect("127.0.0.1", 9000).sync();

            //对通道关闭进行监听，closeFuture是异步操作，监听通道关闭
            // 通过sync方法同步等待通道关闭处理完毕，这里会阻塞等待通道关闭完成
            cf.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
