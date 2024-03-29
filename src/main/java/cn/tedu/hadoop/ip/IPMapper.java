package cn.tedu.hadoop.ip;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class IPMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        context.write(value, NullWritable.get());
    }

}
