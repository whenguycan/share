package com.lepus.netty.proxy;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;

/**
 * 
 * @author whenguycan
 * @date 2018年1月24日 下午3:57:07
 */
public class HttpClient {
	
	public static ExecutorService pool = Executors.newFixedThreadPool(3);
	
	public static ChannelFuture future = null;
	
	public static ChannelHandlerContext ctx = null;
	
	public static FullHttpRequest msg = null;
	
	public static void main(String[] args){
		try {
			future = start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		bind(2080);
	}

	public static ChannelFuture start() throws Exception {
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(workerGroup)
				.channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.option(ChannelOption.SO_KEEPALIVE, true)
				.handler(new ChannelInitializer<Channel>() {
					protected void initChannel(Channel ch) throws Exception{
						ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
							public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
								ByteBuf resp = (ByteBuf)msg;
								byte[] bytes = new byte[resp.readableBytes()];
								resp.readBytes(bytes);
								if(HttpClient.msg != null ){
									System.out.println(HttpClient.msg.decoderResult().isSuccess());
									if(HttpClient.msg.decoderResult().isSuccess()){
										HttpClient.ctx.writeAndFlush(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.copiedBuffer(new String(bytes), CharsetUtil.UTF_8)));
										HttpClient.ctx.close();
									}
								}
								resp.release();
							}
						});
					}
				});
		ChannelFuture future = bootstrap.connect("192.168.1.105", 60000).sync();
		return future;
	}
	
	public static void bind(int... ports) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workerGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception{
					ch.pipeline()
						.addLast("http-decoder", new HttpRequestDecoder())
						.addLast("http-aggregator", new HttpObjectAggregator(65535))
						.addLast("http-encoder", new HttpResponseEncoder())
						.addLast("http-chunked", new ChunkedWriteHandler())
						.addLast("dataHandler", new DataHandler());
				}
			})
			.option(ChannelOption.SO_BACKLOG, 128)
			.childOption(ChannelOption.SO_KEEPALIVE, true);
			Set<Channel> channels = new HashSet<Channel>();
			for(int port : ports){
				Channel ch = bootstrap.bind(port).sync().channel();
				channels.add(ch);
				ch.closeFuture().sync();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
	
	public static class DataHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

		@Override
		protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception{
			msg.headers().entries().forEach(entry -> {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			});
			HttpClient.ctx = ctx;
			HttpClient.msg = msg;
			future.channel().writeAndFlush(Unpooled.copiedBuffer("from chrome".getBytes()));
		}
		
	}
	
}
