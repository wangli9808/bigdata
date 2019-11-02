package cn.tedu.hadoop.wordcount2;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WMapper
        extends Mapper<LongWritable, Text, Text, LongWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] arr = value.toString().split(" ");
        for (String str : arr) {
            context.write(new Text(str), new LongWritable(1));
        }

    }

}
