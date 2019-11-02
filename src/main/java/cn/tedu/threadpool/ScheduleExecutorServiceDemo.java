package cn.tedu.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduleExecutorServiceDemo {
    public static void main(String[] args) {
        Long sum = 0L;
        for (Long i = 0L; i < 1000000000L; i++) {
            sum += i;
            System.out.println(sum);
        }
    }
}
