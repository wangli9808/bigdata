package cn.tedu.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static Integer i = 0;

    public static void main(String[] args) throws InterruptedException {
        Lock l = new ReentrantLock();
        new Thread(new Add()).start();
        new Thread(new Add()).start();
        Thread.sleep(3000);
        System.out.println(i);
    }
}

class Add implements Runnable {
    private Lock l;
//    l.lock

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            LockDemo.i++;
        }
    }
}
