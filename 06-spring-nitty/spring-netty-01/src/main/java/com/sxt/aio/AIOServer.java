package com.sxt.aio;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AIOServer {

    private static final Logger LOGGER = Logger.getLogger(AIOServer.class);

    public static void main( String[] args ) throws IOException, InterruptedException {
        //1、创建Server端
        AsynchronousServerSocketChannel serverSocketChannelServer = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(9000));

        serverSocketChannelServer.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            /**
             *
             * @param socketChannel
             * @param attachment
             */
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {
                try {
                    LOGGER.info("2‐‐"+Thread.currentThread().getName());
                    // 再此接收客户端连接，如果不写这行代码后面的客户端连接连不上服务端
                    serverSocketChannelServer.accept(attachment,this);

                    System.out.println(socketChannel.getRemoteAddress());

                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    socketChannel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                        /**
                         *
                         * @param result
                         * @param attachment
                         */
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            System.out.println("3‐‐"+Thread.currentThread().getName());
                            buffer.flip();
                            System.out.println(new String(buffer.array(), 0, result));
                            socketChannel.write(ByteBuffer.wrap("HelloClient".getBytes()));
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            exc.printStackTrace();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /**
             *
             * @param exc
             * @param attachment
             */
            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });

        System.out.println("1‐‐"+Thread.currentThread().getName());

        Thread.currentThread().sleep(Integer.MAX_VALUE);
    }
}
