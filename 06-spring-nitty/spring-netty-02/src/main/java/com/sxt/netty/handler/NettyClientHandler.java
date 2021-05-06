package com.sxt.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

/**
 * 客户端处理任务
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger LOGGER = Logger.getLogger(NettyClientHandler.class);

    /**
     * 当客户端连接服务端便会触发的执行方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //        super.channelActive(ctx);
        ByteBuf buf = Unpooled.copiedBuffer("HelloServer", CharsetUtil.UTF_8);
        ctx.writeAndFlush(buf);
    }

    /**
     *
     * @param ctx 上下文对象, 含有通道channel，管道pipeline
     * @param msg 就是客户端发送的数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        LOGGER.info(("服务器读取线程 " + Thread.currentThread().getName()));
        //将 msg 转成一个 ByteBuf，类似NIO 的 ByteBuffer
        ByteBuf byteBuffer = (ByteBuf) msg;

        LOGGER.info("客户端发送消息是:" + byteBuffer.toString(CharsetUtil.UTF_8));
        LOGGER.info("服务端的地址：:" + ctx.channel().remoteAddress());
    }

    /**
     * 数据读取完毕处理方法
     * @param ctx 上下文对象, 含有通道channel，管道pipeline
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //super.channelReadComplete(ctx);
        ByteBuf buf = Unpooled.copiedBuffer("HelloWorld", CharsetUtil.UTF_8);
        ctx.writeAndFlush(buf);
    }

    /**
     * 处理异常, 一般是需要关闭通道
     * @param ctx 上下文对象, 含有通道channel，管道pipeline
     * @param cause 原因
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        //关闭流
        ctx.close();
    }
}
