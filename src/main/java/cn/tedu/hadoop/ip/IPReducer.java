package cn.tedu.hadoop.ip;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class IPReducer extends Reducer<Text, NullWritable, Text, NullWritable> {

    // key = IP
    // value = null,null,null
    @Override
    public void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {

        context.write(key, NullWritable.get());

    }

}
