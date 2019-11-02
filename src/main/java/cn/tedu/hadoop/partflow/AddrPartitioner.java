package cn.tedu.hadoop.partflow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AddrPartitioner extends Partitioner<Text, Flow> {

    // 指定分类规则
    @Override
    public int getPartition(Text key, Flow value, int numReduceTasks) {

        // 按照地区分类
        // 先拿到地区
        String addr = value.getAddr();

        if (addr.equals("bj")) {
            return 0;
        } else if (addr.equals("sh")) {
            return 1;
        } else {
            return 2;
        }

    }

}
