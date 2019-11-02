package cn.tedu.hadoop.maxscore;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxScoreMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] arr = value.toString().split(" ");
        context.write(new Text(arr[0]), new IntWritable(Integer.parseInt(arr[1])));

    }

}
