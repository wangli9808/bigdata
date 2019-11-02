package cn.tedu.nio;

import java.nio.ByteBuffer;

/**
 * @author tarena
 */
public class ByteBufferDemo {
    public static void main(String[] args) {
//        ByteBuffer byteBuffer = new ByteBuffer();//bytebuffer是抽象类，反射只能创建实体类对象
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        //添加数据
        byteBuffer.put("abc".getBytes());
        byteBuffer.put((byte) 0);
        byteBuffer.put("def".getBytes());

        //获取当前操作位
        //byteBuffer.position();
        //挪动limit位置
        byteBuffer.limit(byteBuffer.position());
        //挪动position位置
        byteBuffer.position(0);

        while (byteBuffer.position() < byteBuffer.limit()) {
            byte i = byteBuffer.get();
            System.out.println(i);
        }
        //获取数据
//        byte i = byteBuffer.get();
//        System.out.println(i);

    }
}
