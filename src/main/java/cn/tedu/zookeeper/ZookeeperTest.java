package cn.tedu.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author tarena
 */
public class ZookeeperTest {
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

    //创建节点
    @Test
    public void createNote() throws KeeperException, InterruptedException {
        String name = zooKeeper.create("/log", "log server".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(name);

    }

    //修改数据
    @Test
    public void setData() throws KeeperException, InterruptedException {
        //如果version为-1，忽略版本，强制修改
        Stat s = zooKeeper.setData("/log", "hello log".getBytes(), 0);
        System.out.println(s);
    }

    //获取数据
    @Test
    public void getData() throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData("/log", null, null);
        System.out.println(new String(data));
    }

    //删除节点
    @Test
    public void deleteNode() throws KeeperException, InterruptedException {
        zooKeeper.delete("/log", -1);
    }

    //获取子节点
    @Test
    public void getChildrenNode() throws KeeperException, InterruptedException {
        List<String> childrenNames = zooKeeper.getChildren("/", null);
        for (String name : childrenNames
        ) {
            System.out.println(name);
        }
    }

    //判断节点是否存在
    @Test
    public void exists() throws KeeperException, InterruptedException {
        //节点存在返回节点信息，不存在返回null
        Stat stat = zooKeeper.exists("/log", null);
        System.out.println(stat == null);
    }

    //
}
