package cn.tedu.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class BlockingqueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");

//        queue.add("d");
//        System.out.println(queue.remove());
//        boolean d = queue.offer("d");
//        System.out.println(queue.poll());
//        System.out.println(d);

//        queue.put("d");
//        System.out.println(queue.take());
        queue.offer("d", 5, TimeUnit.SECONDS);
        System.out.println(queue);
        System.out.println(queue.poll());


    }
}
