package com.qunar.study.xiaosxian.java8.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class SelectorDemo {
	//客户端
	public void client() throws IOException {
		//1.获取socketChannel
		SocketChannel sChannel = SocketChannel.open();
		//2.创建连接
		sChannel.connect(new InetSocketAddress("127.0.0.1", 9898));
		ByteBuffer buf = ByteBuffer.allocate(1024);
		//3.设置通道为非阻塞
		sChannel.configureBlocking(false);
		
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String msg = scanner.nextLine();
			buf.put((new Date() + ": " + msg).getBytes());
			buf.flip();
			sChannel.write(buf);
			buf.clear();
		}
	}
	//服务端
	public void server() throws IOException {
		//1.获取服务端通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		ssChannel.bind(new InetSocketAddress(9898));
		//2.设置为非阻塞
		ssChannel.configureBlocking(false);
		//3.打开一个监听器
		Selector selector = Selector.open();
		//4.向监听器注册接受事件
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (selector.select() > 0) {
			Iterator<SelectionKey> it =  selector.selectedKeys().iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				if (key.isAcceptable()) {
					SocketChannel socketChannel = ssChannel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
				} else if (key.isReadable()) {
					SocketChannel channel = (SocketChannel) key.channel();
					readMsg(channel);
				}
				it.remove();
			}
		}
	}
	private void readMsg(SocketChannel channel) throws IOException {
		ByteBuffer buf = ByteBuffer.allocate(1024);
		int len = 0;
		while ((len = channel.read(buf)) > 0) {
			buf.flip();
			byte[] bytes = new byte[1024];
			buf.get(bytes, 0, len);
			System.out.println(new String(bytes,0,len));
		}
	}
	
}
