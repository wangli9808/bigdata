package cn.tedu.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端通道
        SocketChannel channel = SocketChannel.open();
        //设置为非阻塞
        channel.configureBlocking(false);
        //发起连接
        channel.connect(new InetSocketAddress("localhost", 8070));
        //判断是否建立连接
        while (!channel.isConnected()) {
            //如果没有，试图再次连接
            //如果多次失败，意味着连接无效
            //底层会自动计数，多次失败时抛出异常
            channel.finishConnect();
        }
        //发送数据
        channel.write(ByteBuffer.wrap("hello,server".getBytes()));
        //接收数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //关流
        channel.close();


    }
}
