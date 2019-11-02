package cn.tedu.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class server {
    public static void main(String[] args) throws IOException {
        //开启服务器端的通道
        ServerSocketChannel channel = ServerSocketChannel.open();
        //绑定监听端口
        channel.bind(new InetSocketAddress(8070));
        //设置非阻塞
        channel.configureBlocking(false);
        //接收连接
        SocketChannel accept = channel.accept();
        //判断连接是否接受
        while (accept == null) {
            accept = channel.accept();
        }
        //接收数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        accept.read(buffer);
        buffer.flip();
        System.out.println(new String(buffer.array(), 0, buffer.limit()));

    }
}
