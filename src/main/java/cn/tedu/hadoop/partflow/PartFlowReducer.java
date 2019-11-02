package cn.tedu.hadoop.partflow;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PartFlowReducer extends Reducer<Text, Flow, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<Flow> values, Context context) throws IOException, InterruptedException {

        int sum = 0;
        for (Flow val : values) {
            sum += val.getFlow();
        }
        context.write(key, new IntWritable(sum));
    }

}
