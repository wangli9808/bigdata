package cn.tedu.nio;

import java.nio.ByteBuffer;

/**
 * @author tarena
 */
public class ByteBufferDemo02 {
    public static void main(String[] args) {
        //创建缓冲区添加初始元素
        //指定了缓冲区的初始元素以及长度
        ByteBuffer buffer = ByteBuffer.wrap("hello".getBytes());
        //无论什么方式创建缓冲区，默认初始位置都是0
        System.out.println(buffer.position());
//        buffer.put("a".getBytes());

        byte[] array = buffer.array();
        System.out.println(new String(array, 0, buffer.limit()));
    }
}
