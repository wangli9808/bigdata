package cn.tedu.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author tarena
 */
public class ZookeeperTest02 {
    ZooKeeper zooKeeper = null;

    @Before
    public void connect() throws IOException, InterruptedException {
        CountDownLatch count = new CountDownLatch(1);
        zooKeeper = new ZooKeeper("10.42.10.101:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("connect successfully!");
                    count.countDown();
                }
            }
        });//sessionTimeout,默认4000-40000之间，毫秒,watcher监控者，连接是否成功
        count.await();
        System.out.println("测试线程结束");
    }

    //监控节点数据是否被改变
    @Test
    public void dataChangged() throws KeeperException, InterruptedException {
        CountDownLatch count = new CountDownLatch(1);

        zooKeeper.getData("/log", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                    System.out.println("节点数据发生变化");
                    count.countDown();
                }
            }
        }, null);
        count.await();
    }


}
