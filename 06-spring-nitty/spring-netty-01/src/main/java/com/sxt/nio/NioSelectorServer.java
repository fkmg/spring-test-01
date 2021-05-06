package com.sxt.nio;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

public class NioSelectorServer {

    private static final Logger LOGGER = Logger.getLogger(NioSelectorServer.class);

    public static void main( String[] args ) throws IOException {
        //1、创建ServerSocketServer
        ServerSocketChannel serverSocketServer = ServerSocketChannel.open();

        //2、注册配置信息
        serverSocketServer.socket().bind(new InetSocketAddress(9000));

        //3、设置非阻塞
        serverSocketServer.configureBlocking(false);

        //4、打开Selector处理Channel，即创建epoll

        Selector selector = Selector.open();

        //5、把ServerSocketChannel注册到selector上，并且selector对客户端accept连接操作感兴趣
        serverSocketServer.register(selector, SelectionKey.OP_ACCEPT);
        LOGGER.info("服务启动成功");

        while (true){
            //6、阻塞等待需要处理的事件发生
            selector.select();
            //7、获取selector中注册的全部事件的 SelectionKey 实例
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            if(selectionKeys != null && !selectionKeys.isEmpty()){
                selectionKeys.forEach(selectionkey->{
                    //连接事件
                    if (selectionkey.isAcceptable()){
                        //注册读事件
                        ServerSocketChannel server = (ServerSocketChannel) selectionkey.channel();
                        try {
                            SocketChannel socketChannel = server.accept();
                            //设置非阻塞
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector,SelectionKey.OP_READ);
                            LOGGER.info("客户端连接成功!");

                        } catch (ClosedChannelException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else if (selectionkey.isReadable()){
                        SocketChannel socketChannel = (SocketChannel) selectionkey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                        try {
                            int len = socketChannel.read(byteBuffer);
                            // 如果有数据，把数据打印出来
                            if (len > 0) {
                                System.out.println("接收到消息：" + new String(byteBuffer.array()));
                            }else if (len == -1){ // 如果客户端断开连接，关闭Socket
                                System.out.println("客户端断开连接");
                                socketChannel.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    //从事件集合里删除本次处理的key，防止下次select重复处理
                    selectionKeys.remove(selectionkey);
                });
            }
        }
    }
}
