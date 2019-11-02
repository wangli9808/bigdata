package cn.tedu.blockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author tarena
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
//        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>();
        PriorityBlockingQueue<Student> queue = new PriorityBlockingQueue<Student>();
        queue.add(new Student("尼古拉·奥斯特洛夫斯基", 11, 44));
        queue.add(new Student("曹阳", 12, 55));
        queue.add(new Student("保尔·柯察金", 13, 66));
        queue.add(new Student("爱新觉罗·赙仪", 14, 77));
        queue.add(new Student("独孤求败", 15, 88));
        queue.add(new Student("渣渣辉", 16, 99));
        queue.add(new Student("陈小春", 17, 33));
        queue.add(new Student("刘翔", 18, 22));

    }
}
