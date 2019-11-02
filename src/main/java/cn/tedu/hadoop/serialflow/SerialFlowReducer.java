package cn.tedu.hadoop.serialflow;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// 统计每一个人出现的位置 --- Text, Text
// 统计每一个人拥有的手机号 --- Text, Text
// 统计每一个人花费的总流量 --- Text, IntWritable
public class SerialFlowReducer
        extends Reducer<Text, Flow, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<Flow> values, Context context) throws IOException, InterruptedException {

        int sum = 0;
        for (Flow val : values) {
            sum += val.getFlow();
        }
        context.write(key, new IntWritable(sum));
    }

}
