package cn.tedu.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo02 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
    }
}
