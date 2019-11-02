package cn.tedu.concurrentmap;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author tarena
 */
public class ConcurrentNavigableMmapDemo {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();
        map.put("a", 1);
        map.put("e", 2);
        map.put("d", 3);
        map.put("c", 4);
        map.put("b", 5);
        System.out.println(map);
        System.out.println(map.headMap("c"));
        System.out.println(map.tailMap("c"));
        System.out.println(map.subMap("b", "e"));

    }
}
