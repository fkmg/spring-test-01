package com.sxt.bio;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class SocketServer {

    private static final Logger LOGGER = Logger.getLogger(SocketServer.class);

    public static void main( String[] args ) throws IOException {
        //1、创建server端
        ServerSocket serverSocket = new ServerSocket(9000);

        while (true){
            LOGGER.info("等待连接");

            Socket clientSocket = serverSocket.accept();

            LOGGER.info("有客户端连接");

            hadleSocket(clientSocket);
        }
    }

    public static void hadleSocket(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        LOGGER.info("准备read。。");
        //接收客户端的数据，阻塞方法，没有数据可读时就阻塞
        int read = clientSocket.getInputStream().read(bytes);
        LOGGER.info("read完毕。。");
        if (read!=-1) {
             LOGGER.info("接收到客户端的数据：" + new String(bytes, 0, read));
        }
        clientSocket.getOutputStream().write("HelloClient".getBytes());
        clientSocket.getOutputStream().flush();

    }
}
