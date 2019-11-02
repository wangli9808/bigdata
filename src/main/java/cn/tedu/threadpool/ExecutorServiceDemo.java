package cn.tedu.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("拒绝执行请求" + r);
            }
        });
        for (int i = 0; i < 15; i++) {
            executor.execute(new ExecutorThread());
        }
        executor.shutdown();
    }
}

class ExecutorThread implements Runnable {

    @Override
    public void run() {
        System.out.println("hello,i am running");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over~~~~");
    }
}
